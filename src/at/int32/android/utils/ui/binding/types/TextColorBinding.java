package at.int32.android.utils.ui.binding.types;

import android.widget.TextView;
import at.int32.android.utils.ui.binding.BindingRunnable;

public class TextColorBinding extends BindingRunnable<Integer, TextView> {

	public TextColorBinding(TextView... view) {
		super(view);
	}

	@Override
	public void run(Integer color) {
		for (TextView view : getViews())
			view.setTextColor(color);
	}
}
