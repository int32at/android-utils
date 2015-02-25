package at.int32.android.utils.bus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class Bus {
	private Handler mainHandler = new Handler(Looper.getMainLooper());
	private ConcurrentHashMap<Object, ArrayList<Method>> handlers;
	private RunOnThread thread;

	public Bus() {
		this(RunOnThread.ANY);
	}
	
	public Bus(RunOnThread thread) {
		this.thread = thread;
		this.handlers = new ConcurrentHashMap<Object, ArrayList<Method>>();
	}

	public void register(Object register) {
		if (register == null)
			return; // todo throw exception here
		
		Method[] methods = register.getClass().getMethods();

		ArrayList<Method> found = new ArrayList<Method>();

		for (Method method : methods) {

			if (method.isAnnotationPresent(Subscribe.class)) {
				found.add(method);
			}
		}

		this.handlers.put(register, found);
	}

	public void unregister(Object register) {
		this.handlers.remove(register);
	}
	
	public <T> void publish(final Event<T> event) {

		if(thread == RunOnThread.MAIN) {
			if(Looper.myLooper() == Looper.getMainLooper())
				publishEvent(event);
			else {
				mainHandler.post(new Runnable() {
					
					@Override
					public void run() {
						publishEvent(event);;
					}
				});
			}
		} else {
			publishEvent(event);
		}
	}
	
	private <T> void publishEvent(Event<T> event) {
		
		for (Object register : this.handlers.keySet()) {
			for (Method method : this.handlers.get(register)) {
				for (Class<?> c : method.getParameterTypes()) {
					if (c == event.getClass()) {

						try {
							method.invoke(register, event);
						} catch (IllegalAccessException e) {
							Log.d("bus", "exception", e);
						} catch (IllegalArgumentException e) {
							Log.d("bus", "exception", e);
						} catch (InvocationTargetException e) {
							Log.d("bus", "exception", e);
						}
					}
				}
			}
		}
	}

}
