package at.int32.android.utils.ui.binding;

import java.util.ArrayList;

import android.view.View;
import android.widget.TextView;
import at.int32.android.utils.ui.binding.types.TextBinding;

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
		if (!runnings.contains(runnable))
			runnings.add(runnable);
		return this;
	}

	public Bindable<T> unbindFrom(View view) {

		ArrayList<BindingRunnable<T, ? extends View>> delete
			= new ArrayList<BindingRunnable<T, ? extends View>>();

		for (BindingRunnable<T, ? extends View> r : runnings) {
			for (View v : r.getViews()) {
				if (v.getId() == view.getId()) {
					delete.add(r);
				}
			}
		}
		
		runnings.removeAll(delete);

		return this;
	}

	public void initialize() {
		run();
	}

	public TextBinding<T> textBinding(TextView... textViews) {
		return new TextBinding<T>(textViews);
	}

	private void run() {
		for (BindingRunnable<T, ? extends View> run : runnings) {
			run.run(this.data);
		}
	}
}
