package at.int32.android.utils.sample.simple;

import android.app.Activity;
import android.content.Context;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import at.int32.android.utils.sample.R;
import at.int32.android.utils.ui.binding.IViewHolder;
import at.int32.android.utils.ui.binding.controls.BindableEditText;
import at.int32.android.utils.ui.binding.controls.BindableNumberPicker;

public class SimpleViewHolder implements IViewHolder {
	public TextView name, sec;
	public ListView skills;
	
	public BindableEditText name_edit;
	public BindableNumberPicker sec_edit;
	
	public Button reset, add;
	
	public Context context;
	
	public SimpleViewHolder(Activity activity) {
		
		context = activity;
		
		reset = (Button)activity.findViewById(R.id.btn_reset);
		add = (Button)activity.findViewById(R.id.btn_add);
		
		name = (TextView)activity.findViewById(R.id.simple_name);
		sec = (TextView)activity.findViewById(R.id.simple_sec);
		skills = (ListView)activity.findViewById(R.id.simple_list);
		
		name_edit = (BindableEditText)activity.findViewById(R.id.simple_name_edit);
		sec_edit = (BindableNumberPicker)activity.findViewById(R.id.simple_sec_edit);

	}
}
