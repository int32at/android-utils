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

	protected void each(T data) {
		for (V view : views) {
			run(data, view);
		}
	}

}
