package at.int32.android.utils.ui.binding;

import java.util.ArrayList;
import java.util.Set;

import android.view.View;

public class Bindable<T> {
	private T data;

	private ArrayList<BindingRunnable<T, ? extends View>> runnings;

	public Bindable(T data) {
		this.data = data;
		this.runnings = new ArrayList<BindingRunnable<T, ? extends View>>();
	}

	public Bindable() {
		this(null);
	}

	public T get() {
		return this.data;
	}

	public void set(T data) {
		this.data = data;
		run();
	}
	
	public Bindable<T> bindTo(BindingRunnable<T, ? extends View> runnable) {
		if(!runnings.contains(runnable))
			runnings.add(runnable);
		return this;
	}
	
	public void initialize() {
		run();
	}

	private void run() {
		for (BindingRunnable<T, ? extends View> run : runnings) {
			run.run(this.data);
		}
	}
}
