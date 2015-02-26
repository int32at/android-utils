package at.int32.android.utils.ui.binding.types;

import android.view.View;
import at.int32.android.utils.ui.binding.Binding;

public class FocusBinding extends Binding<Boolean, View> {

	@Override
	public void run(Boolean focus, View view) {
		if(view == null) return;
		if(focus)
			view.requestFocus();
		else
			view.clearFocus();
	}
}
