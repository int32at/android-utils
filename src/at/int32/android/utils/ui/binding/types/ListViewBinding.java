package at.int32.android.utils.ui.binding.types;

import android.widget.ListAdapter;
import android.widget.ListView;
import at.int32.android.utils.ui.binding.Binding;

public class ListViewBinding extends Binding<ListAdapter, ListView> {
	
	public ListViewBinding(ListView... views) {
		super(views);
	}
	
	@Override
	public void run(ListAdapter data, ListView view) {
		if(view != null)
			view.setAdapter(data);
	}

}
