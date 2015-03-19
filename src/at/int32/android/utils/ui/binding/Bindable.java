package at.int32.android.utils.ui.binding;

import java.util.ArrayList;

import android.util.Log;
import android.view.View;

public class Bindable<T> {
	private T data;

	private ArrayList<Binding<T, ? extends View>> bindings;
	private ArrayList<IViewBinding<T, ? extends Bindable<T>>> twoWayBindings;

	public Bindable(T data) {
		this.data = data;
		this.bindings = new ArrayList<Binding<T, ? extends View>>();
		this.twoWayBindings = new ArrayList<IViewBinding<T, ? extends Bindable<T>>>();
	}

	public Bindable() {
		this(null);
	}

	public T get() {
		return this.data;
	}

	public void set(T data) {
		set(data, false);
	}

	public void set(T data, boolean twoWay) {
		this.data = data;
		
		Log.i("utils", "setting data to =" + data+ " + twoWay =" + twoWay);
		run(twoWay);
	}

	public Bindable<T> bindTo(Binding<T, ? extends View> view) {

		this.bindings.add(view);

		return this;
	}
	
	public Bindable<T> bindTo(IViewBinding<T, ? extends Bindable<T>> binding) {
		binding.bindTo(this);
		this.twoWayBindings.add(binding);
		
		return this;
	}

	public Bindable<T> initialize() {
		run(false);
		return this;
	}

	private void run(boolean twoWay) {
		for (Binding<T, ? extends View> binding : bindings) {
			binding.each(data);
			Log.i("utils", "updated binding = " + binding);
		}
		
		for (IViewBinding<T, ? extends Bindable<T>> two : twoWayBindings) {
			two.update(data, twoWay);
			Log.i("utils", "updated binding TwoWay = " + two);
		}
	}
}
