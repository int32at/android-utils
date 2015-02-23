package at.int32.android.utils.ui.binding.types;

import android.view.View;
import at.int32.android.utils.ui.binding.BindingRunnable;

public class BackgroundColorBinding extends BindingRunnable<Integer, View> {

	public BackgroundColorBinding(View... view) {
		super(view);
	}

	@Override
	public void run(Integer color) {
		for (View view : getViews()) {
			view.setBackgroundColor(color);
		}
	}
}
