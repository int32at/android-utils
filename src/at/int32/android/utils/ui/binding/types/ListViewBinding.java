package at.int32.android.utils.ui.binding.types;

import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.ListView;
import at.int32.android.utils.ui.binding.Binding;

public class ListViewBinding extends Binding<BaseAdapter, ListView> {
	
	public ListViewBinding(ListView... views) {
		super(views);
	}
	
	@Override
	public void run(BaseAdapter data, ListView view) {
		if(view != null) {
			view.setAdapter(data);
			Log.e("sampleapp", "set view adapter");
		}
	}
}
