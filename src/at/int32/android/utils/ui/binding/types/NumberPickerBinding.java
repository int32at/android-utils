package at.int32.android.utils.ui.binding.types;

import android.widget.NumberPicker;
import at.int32.android.utils.ui.binding.Binding;

public class NumberPickerBinding extends Binding<Integer, NumberPicker> {

	public NumberPickerBinding(NumberPicker... views) {
		super(views);
	}

	@Override
	public void run(Integer data, NumberPicker view) {
		if (view != null)
			view.setValue(data);
	}

}
