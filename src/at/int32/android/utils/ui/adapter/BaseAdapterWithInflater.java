package at.int32.android.utils.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

public abstract class BaseAdapterWithInflater extends BaseAdapter {

	protected LayoutInflater inflater;
	protected Context context;
	
	public BaseAdapterWithInflater(Context context) {
		this.context = context;
		this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
}
