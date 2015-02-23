package at.int32.android.utils.ui.binding.types;

import android.widget.TextView;
import at.int32.android.utils.ui.binding.BindingRunnable;

public class TextBinding<T> extends BindingRunnable<T, TextView> {

	public TextBinding(TextView... textViews) {
		super(textViews);
	}

	@Override
	public void run(T data) {
		for (TextView view : getViews())
			view.setText(data.toString());
	}

}