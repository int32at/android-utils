package at.int32.android.utils.samples.binding;

import android.view.View;
import android.view.View.OnClickListener;
import at.int32.android.utils.ui.binding.bindable.IntegerBindable;
import at.int32.android.utils.ui.binding.bindable.StringBindable;
import at.int32.android.utils.ui.binding.controls.BindableEditText;
import at.int32.android.utils.ui.binding.controls.BindableNumberPicker;
import at.int32.android.utils.ui.binding.controls.BindableSeekBar;
import at.int32.android.utils.ui.binding.types.SeekBarBinding;
import at.int32.android.utils.ui.binding.types.TextBinding;

public class ViewModel extends at.int32.android.utils.ui.binding.ViewModel<ViewHolder> {

	private StringBindable name;
	private IntegerBindable age;
	
	public ViewModel() {
		this.name = new StringBindable("Andreas");
		this.age = new IntegerBindable(24);
	}

	@Override
	public void bind(ViewHolder viewHolder) {

		name.bindTo(new TextBinding<String>(viewHolder.name));
		name.bindTo(new BindableEditText(viewHolder.name_edit));
		
		age.bindTo(new TextBinding<Integer>(viewHolder.age));
		age.bindTo(new SeekBarBinding(viewHolder.test_edit));
		
		age.bindTo(new BindableNumberPicker(viewHolder.age_edit));
		age.bindTo(new BindableSeekBar(viewHolder.test_edit));
		
		viewHolder.age_edit.setMaxValue(100);
		viewHolder.age_edit.setMinValue(0);
		
		viewHolder.reset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				name.set("Andreas");
				age.set(24);
			}
		});
		
		this.name.initialize();
		this.age.initialize();
	}

}
