package at.int32.android.utils.ui.binding;

import java.util.Arrays;
import java.util.List;

import android.view.View;

public abstract class BindingRunnable<T, V extends View> {
	private List<V> views;

	public BindingRunnable(V... views) {
		this.views = Arrays.asList(views);
	}

	public abstract void run(T data);

	protected List<V> getViews() {
		return this.views;
	}
}
