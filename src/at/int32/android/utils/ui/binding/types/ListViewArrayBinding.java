package at.int32.android.utils.ui.binding.types;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import at.int32.android.utils.ui.binding.Binding;

public class ListViewArrayBinding<T> extends Binding<ArrayAdapter<T>, ListView> {
	
	public ListViewArrayBinding(ListView... views) {
		super(views);
	}
	
	@Override
	public void run(ArrayAdapter<T> data, ListView view) {
		if(view != null)
			view.setAdapter(data);
	}
}