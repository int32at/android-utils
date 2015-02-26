package at.int32.android.utils.ui.binding.types;

import android.widget.TextView;
import at.int32.android.utils.ui.binding.Binding;

public class ForegroundColorBinding extends Binding<Integer, TextView> {

	public ForegroundColorBinding(TextView... views) {
		super(views);
	}
	
	@Override
	public void run(Integer color, TextView view) {
		if(view == null) return;
		view.setTextColor(color);
	}

}
