package at.int32.android.utils.ui.binding;

import android.view.View;

public interface IViewRunnable<T, V extends View> {
	public void run(T data, V view);
}