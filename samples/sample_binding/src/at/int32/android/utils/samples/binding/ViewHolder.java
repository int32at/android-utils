package at.int32.android.utils.samples.binding;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import at.int32.android.utils.ui.binding.IViewHolder;
import at.int32.android.utils.ui.binding.controls.BindableEditText;
import at.int32.android.utils.ui.binding.controls.BindableNumberPicker;

public class ViewHolder implements IViewHolder {

	public TextView name, age;

	// bindable view for 2-Way-Binding
	public BindableEditText name_edit;
	public BindableNumberPicker age_edit;

	// reset button
	public Button reset;

	public ViewHolder(Activity activity) {
		name = (TextView) activity.findViewById(R.id.name);
		age = (TextView) activity.findViewById(R.id.age);

		name_edit = (BindableEditText) activity.findViewById(R.id.name_edit);
		age_edit = (BindableNumberPicker) activity.findViewById(R.id.age_edit);

		reset = (Button) activity.findViewById(R.id.btn_reset);
	}
}
