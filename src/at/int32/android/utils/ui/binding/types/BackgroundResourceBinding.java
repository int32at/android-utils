package at.int32.android.utils.ui.binding.types;

import android.view.View;
import at.int32.android.utils.ui.binding.Binding;

public class BackgroundResourceBinding extends Binding<Integer, View> {

	public BackgroundResourceBinding(View... views) {
		super(views);
	}

	@Override
	public void run(Integer id, View view) {
		if (view == null)
			return;
		view.setBackgroundResource(id);
	}

}
