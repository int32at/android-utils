package at.int32.android.utils.sample;

import android.app.Activity;
import at.int32.android.utils.sample.simple.SimpleViewHolder;
import at.int32.android.utils.sample.simple.SimpleViewModel;

public class Loader {

	public static void load(Activity activity) {
		loadSimple(activity);
	}
	
	private static void loadSimple(Activity activity) {

		SimpleViewModel model = new SimpleViewModel();
		model.bind(new SimpleViewHolder(activity));
		
	}
}
