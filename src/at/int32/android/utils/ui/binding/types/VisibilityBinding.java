package at.int32.android.utils.ui.binding.types;

import android.view.View;
import at.int32.android.utils.ui.binding.Binding;

public class VisibilityBinding extends Binding<Boolean, View> {

	public VisibilityBinding(View... views) {
		super(views);
	}

	@Override
	public void run(Boolean visible, View view) {
		if (view == null)
			return;

		view.setVisibility(visible ? View.VISIBLE : View.GONE);
	}
}
