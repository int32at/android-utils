package at.int32.android.utils.sample.simple;

import java.util.ArrayList;

import android.R;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import at.int32.android.utils.ui.binding.ViewModel;
import at.int32.android.utils.ui.binding.bindable.ArrayAdapterBindable;
import at.int32.android.utils.ui.binding.bindable.IntegerBindable;
import at.int32.android.utils.ui.binding.bindable.StringBindable;
import at.int32.android.utils.ui.binding.types.ListViewArrayBinding;
import at.int32.android.utils.ui.binding.types.NumberPickerBinding;
import at.int32.android.utils.ui.binding.types.TextBinding;

public class SimpleViewModel extends ViewModel<SimpleViewHolder> {

	private StringBindable name;
	private IntegerBindable sec;
	private ArrayAdapterBindable<String> skills;
	
	private static String defaultName = "Andreas";
	private static int defaultSec = 24;

	public SimpleViewModel(Context context) {
		name = new StringBindable(defaultName);
		sec = new IntegerBindable(defaultSec);
		
		skills = new ArrayAdapterBindable<String>(context, R.layout.simple_list_item_1, getDefaultSkills());
	}

	@Override
	public void bind(SimpleViewHolder viewHolder) {

		viewHolder.name_edit.bindTo(this.name);
		this.name.bindTo(new TextBinding<String>(viewHolder.name_edit)).initialize();
		
		viewHolder.sec_edit.bindTo(this.sec);		
		this.sec.bindTo(new NumberPickerBinding(viewHolder.sec_edit)).initialize();
		
		this.name.bindTo(new TextBinding<String>(viewHolder.name)).initialize();
		this.sec.bindTo(new TextBinding<Integer>(viewHolder.sec)).initialize();
		
		this.skills.bindTo(new ListViewArrayBinding<String>(viewHolder.skills)).initialize();
		
		viewHolder.reset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				name.set(defaultName);
				sec.set(defaultSec);
				skills.set(getDefaultSkills());
			}
		});
		
		viewHolder.add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				skills.get().add("sample");
			}
		});
	}
	
	private static ArrayList<String> getDefaultSkills() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Java");
		list.add("Android");
		list.add("Frameworks");
		return list;
	}

}
