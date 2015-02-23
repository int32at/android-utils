package at.int32.android.utils.ui.binding.types;

import android.widget.TextView;
import at.int32.android.utils.ui.binding.BindingRunnable;

public class TextBinding extends BindingRunnable<String, TextView> {

	public TextBinding(TextView... view) {
		super(view);
	}

	@Override
	public void run(String data) {

		for (TextView view : getViews())
			view.setText(data);
	}
}
