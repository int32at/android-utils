package at.int32.android.utils.samples.binding;

import android.app.Activity;
import android.content.Context;
import android.widget.Button;
import android.widget.TextView;
import at.int32.android.utils.ui.binding.controls.BindableEditText;
import at.int32.android.utils.ui.binding.controls.BindableNumberPicker;

public class ViewHolder extends at.int32.android.utils.ui.binding.ViewHolder {

	public ViewHolder(Context context) {
		super(context);
		
		name = (TextView) context.findViewById(R.id.name);
		age = (TextView) context.findViewById(R.id.age);

		name_edit = (BindableEditText) activity.findViewById(R.id.name_edit);
		age_edit = (BindableNumberPicker) activity.findViewById(R.id.age_edit);

		reset = (Button) activity.findViewById(R.id.btn_reset);
	}

	public TextView name, age;

	// bindable view for 2-Way-Binding
	public BindableEditText name_edit;
	public BindableNumberPicker age_edit;

	// reset button
	public Button reset;

}
