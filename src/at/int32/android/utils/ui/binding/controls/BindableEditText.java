package at.int32.android.utils.ui.binding.controls;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;
import at.int32.android.utils.ui.binding.Bindable;
import at.int32.android.utils.ui.binding.IViewBindable;
import at.int32.android.utils.ui.binding.bindable.StringBindable;

public class BindableEditText extends EditText implements IViewBindable<String, StringBindable>{

	private StringBindable bindable;
	
	public BindableEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
		
		if(this.bindable != null)
			this.bindable.set(text.toString(), true);
			
		super.onTextChanged(text, start, lengthBefore, lengthAfter);
	}

	@Override
	public void bindTo(StringBindable bindable) {
		this.bindable = bindable;
	}

	@Override
	public void update(String bindable, boolean twoWay) {
		
		Log.d("utilsapp", "received update = " + bindable + " two way = " + twoWay);
		if(!twoWay)
			setText(bindable);
	}
}
