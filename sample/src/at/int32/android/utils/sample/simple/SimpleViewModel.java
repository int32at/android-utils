package at.int32.android.utils.sample.simple;

import java.util.ArrayList;

import android.R;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import at.int32.android.utils.ui.binding.Bindable;
import at.int32.android.utils.ui.binding.ViewModel;
import at.int32.android.utils.ui.binding.bindable.IntegerBindable;
import at.int32.android.utils.ui.binding.bindable.StringBindable;
import at.int32.android.utils.ui.binding.types.ListViewBinding;
import at.int32.android.utils.ui.binding.types.NumberPickerBinding;
import at.int32.android.utils.ui.binding.types.TextBinding;

public class SimpleViewModel extends ViewModel<SimpleViewHolder> {

	private StringBindable name;
	private IntegerBindable sec;
	private Bindable<ListAdapter> skills;
	
	private static String defaultName = "Andreas";
	private static int defaultSec = 24;
	private static ArrayList<String> defaultSkills = new ArrayList<String>() {{
		add("Java");
		add("Android");
		add("Frameworks");
	}};

	public SimpleViewModel() {
		name = new StringBindable(defaultName);
		sec = new IntegerBindable(defaultSec);
		skills = new Bindable<ListAdapter>();
	}

	@Override
	public void bind(SimpleViewHolder viewHolder) {

		viewHolder.name_edit.bindTo(this.name);
		this.name.bindTo(new TextBinding<String>(viewHolder.name_edit)).initialize();
		
		viewHolder.sec_edit.bindTo(this.sec);		
		this.sec.bindTo(new NumberPickerBinding(viewHolder.sec_edit)).initialize();
		
		this.name.bindTo(new TextBinding<String>(viewHolder.name)).initialize();
		this.sec.bindTo(new TextBinding<Integer>(viewHolder.sec)).initialize();
		
		this.skills.set(new ArrayAdapter<String>(viewHolder.context, R.layout.simple_list_item_1, defaultSkills));
		this.skills.bindTo(new ListViewBinding(viewHolder.skills)).initialize();
		
		viewHolder.reset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				name.set(defaultName);
				sec.set(defaultSec);
			}
		});
	}

}
