package at.int32.android.utils.ui.binding;

import java.util.ArrayList;

import android.view.View;

public class Bindable<T> {
	private T data;

	private ArrayList<Binding<T, ? extends View>> bindings;

	public Bindable(T data) {
		this.data = data;
		this.bindings = new ArrayList<Binding<T, ? extends View>>();
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
		run(twoWay);
	}

	public Bindable<T> bindTo(Binding<T, ? extends View> view) {

		this.bindings.add(view);

		return this;
	}

	public Bindable<T> initialize() {
		run(false);
		return this;
	}

	private void run(boolean twoWay) {
		for (Binding<T, ? extends View> binding : bindings) {
			binding.each(data, twoWay);
		}
	}
}
