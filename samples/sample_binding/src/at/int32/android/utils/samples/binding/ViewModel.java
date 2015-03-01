package at.int32.android.utils.samples.binding;

import android.view.View;
import android.view.View.OnClickListener;
import at.int32.android.utils.ui.binding.bindable.IntegerBindable;
import at.int32.android.utils.ui.binding.bindable.StringBindable;
import at.int32.android.utils.ui.binding.types.NumberPickerBinding;
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
		// bind the bindables to the actual text views, we use the TextBinding
		// to set the text
		this.name.bindTo(new TextBinding<String>(viewHolder.name));
		this.age.bindTo(new TextBinding<Integer>(viewHolder.age));

		// 2-Way-Binding name
		viewHolder.name_edit.bindTo(this.name);
		this.name.bindTo(new TextBinding<String>(viewHolder.name_edit));

		// 2-Way-Binding age
		viewHolder.age_edit.bindTo(this.age);
		this.age.bindTo(new NumberPickerBinding(viewHolder.age_edit));

		// reset the values when the reset button is clicked
		// this will udpate the text views and the bindable views aswell
		viewHolder.reset.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				name.set("Andreas");
				age.set(24);
			}
		});

		// call the initialize method when you want to initialize (set the text)
		// right away
		this.name.initialize();
		this.age.initialize();
	}

}
