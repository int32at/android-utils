package at.int32.android.utils.ui.binding.controls;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import at.int32.android.utils.ui.binding.Bindable;
import at.int32.android.utils.ui.binding.IViewBinding;

public class BindableEditText implements IViewBinding<String, Bindable<String>> {
	private EditText edit;
	private Bindable<String> bindable;

	public BindableEditText(EditText text) {
		edit = text;

		edit.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

				if (bindable != null) {
					bindable.set(s.toString(), true);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});
	}

	@Override
	public void update(String bindable, boolean twoWay) {

		if (!twoWay) {
			edit.setText(bindable);
		}
	}

	public void bindTo(Bindable<String> bindable) {
		this.bindable = bindable;
	}
}
