package at.int32.android.utils.ui.binding.types;

import android.view.View;
import at.int32.android.utils.ui.binding.Binding;

public class DisableBinding extends Binding<Boolean, View>{

	public DisableBinding(View... views) {
		super(views);
	}
	
	@Override
	public void run(Boolean data, View view) {
		view.setEnabled(!data);
	}

}
