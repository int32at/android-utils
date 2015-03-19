package at.int32.android.utils.ui.binding.controls;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import at.int32.android.utils.ui.binding.Bindable;
import at.int32.android.utils.ui.binding.IViewBinding;
import at.int32.android.utils.ui.binding.bindable.IntegerBindable;

public class BindableNumberPicker implements
		IViewBinding<Integer, IntegerBindable> {

	private Bindable<Integer> bindable;
	private NumberPicker picker;

	public BindableNumberPicker(NumberPicker picker) {
		this.picker = picker;
		this.picker.setOnValueChangedListener(new OnValueChangeListener() {

			@Override
			public void onValueChange(NumberPicker picker, int oldVal,
					int newVal) {
				
				if (bindable != null) {
					bindable.set(newVal, true);
				}
			}
		});
	}

	@Override
	public void update(Integer bindable, boolean twoWay) {
		if (twoWay)
			picker.setValue(bindable);
	}

	@Override
	public void bindTo(Bindable<Integer> bindable) {
		this.bindable = bindable;
	}

}
