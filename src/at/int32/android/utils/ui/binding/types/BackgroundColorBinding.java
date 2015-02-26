package at.int32.android.utils.ui.binding.types;

import android.view.View;
import at.int32.android.utils.ui.binding.Binding;

public class BackgroundColorBinding extends Binding<Integer, View>{

	public BackgroundColorBinding(View... views) {
		super(views);
	}
	
	@Override
	public void run(Integer color, View view) {
		if(view == null) return;
		view.setBackgroundColor(color);
	}

}
