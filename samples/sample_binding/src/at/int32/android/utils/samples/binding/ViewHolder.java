package at.int32.android.utils.samples.binding;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.TextView;
import at.int32.android.utils.ui.binding.IViewHolder;
import at.int32.android.utils.ui.binding.controls.BindableNumberPicker;

public class ViewHolder implements IViewHolder {

	public TextView name, age;

	// bindable view for 2-Way-Binding
	public EditText name_edit;
	public NumberPicker age_edit;
	public SeekBar test_edit;

	// reset button
	public Button reset;

	public ViewHolder(Activity activity) {
		name = (TextView) activity.findViewById(R.id.name);
		age = (TextView) activity.findViewById(R.id.age);

		name_edit = (EditText) activity.findViewById(R.id.name_edit);
		age_edit = (NumberPicker) activity.findViewById(R.id.age_edit);

		test_edit = (SeekBar) activity.findViewById(R.id.test_edit);
		
		reset = (Button) activity.findViewById(R.id.btn_reset);
	}

}
