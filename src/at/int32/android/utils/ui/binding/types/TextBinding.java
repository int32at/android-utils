package at.int32.android.utils.ui.binding.types;

import android.widget.TextView;
import at.int32.android.utils.ui.binding.Binding;

public class TextBinding<T> extends Binding<T, TextView> {
	
	public TextBinding(TextView... views) {
		super(views);
	}

	@Override
	public void run(T data, TextView view) {
		if(data != null && view != null)
			view.setText(data.toString());
	}
	
}