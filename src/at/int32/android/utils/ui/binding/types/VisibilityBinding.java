package at.int32.android.utils.ui.binding.types;

import android.view.View;
import at.int32.android.utils.ui.binding.BindingRunnable;

public class VisibilityBinding extends BindingRunnable<Boolean, View> {

	public VisibilityBinding(View... view) {
		super(view);
	}

	@Override
	public void run(Boolean enabled) {
		for (View view : getViews())
			view.setVisibility(enabled ? View.VISIBLE : View.GONE);
	}
}
