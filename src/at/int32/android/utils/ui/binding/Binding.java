package at.int32.android.utils.ui.binding;

import java.util.Arrays;
import java.util.List;

import android.view.View;

public abstract class Binding<T, V extends View> implements IViewRunnable<T, V> {

	private List<V> views;

	protected Binding(V... views) {
		this.views = Arrays.asList(views);
	}

	@Override
	public abstract void run(T data, V view);

	protected void each(T data, boolean twoWay) {
		for (V view : views) {
			if (!(view instanceof IViewBindable<?, ?>))
				run(data, view);
			else {
				IViewBindable<T, Bindable<T>> bindable = (IViewBindable<T, Bindable<T>>) view;
				bindable.update(data, twoWay);
			}
		}
	}

}
