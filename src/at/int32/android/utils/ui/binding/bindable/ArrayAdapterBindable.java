package at.int32.android.utils.ui.binding.bindable;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;
import at.int32.android.utils.ui.binding.Bindable;

public class ArrayAdapterBindable<T> extends Bindable<ArrayAdapter<T>> {

	public ArrayAdapterBindable() {
		super();
	}

	public ArrayAdapterBindable(ArrayAdapter<T> defaultValue) {
		super(defaultValue);
	}

	public ArrayAdapterBindable(Context context, int template, List<T> data) {
		super(new ArrayAdapter<T>(context, template, data));
	}
	
	public void set(ArrayList<T> list) {
		get().clear();
		get().addAll(list);
	}
}