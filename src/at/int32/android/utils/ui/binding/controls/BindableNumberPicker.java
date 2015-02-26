package at.int32.android.utils.ui.binding.controls;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import at.int32.android.utils.ui.binding.IViewBindable;
import at.int32.android.utils.ui.binding.bindable.IntegerBindable;

public class BindableNumberPicker extends NumberPicker implements
		IViewBindable<Integer, IntegerBindable>, OnValueChangeListener {

	private IntegerBindable bindable;

	public BindableNumberPicker(Context context) {
		super(context);
	}

	public BindableNumberPicker(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);
	}

	public BindableNumberPicker(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(attrs);
	}

	@Override
	public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
		if (bindable != null)
			bindable.set(newVal);
	}

	@Override
	public void bindTo(IntegerBindable bindable) {
		this.bindable = bindable;
	}

	@Override
	public void update(Integer bindable, boolean twoWay) {
		if (!twoWay)
			setValue(bindable);
	}

	private void init(AttributeSet attrs) {
		setOnValueChangedListener(this);
		processAttributeSet(attrs);
	}

	private void processAttributeSet(AttributeSet attrs) {
		this.setMinValue(attrs.getAttributeIntValue(null, "min_value", 0));
		this.setMaxValue(attrs.getAttributeIntValue(null, "max_value", 0));
	}

}
