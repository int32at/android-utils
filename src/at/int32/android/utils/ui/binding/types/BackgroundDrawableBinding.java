package at.int32.android.utils.ui.binding.types;

import android.graphics.drawable.Drawable;
import android.view.View;
import at.int32.android.utils.ui.binding.Binding;

public class BackgroundDrawableBinding extends Binding<Drawable, View> {

	public BackgroundDrawableBinding(View... views) {
		super(views);
	}

	@Override
	public void run(Drawable drawable, View view) {
		if (view == null)
			return;
		view.setBackgroundDrawable(drawable);
	}

}
