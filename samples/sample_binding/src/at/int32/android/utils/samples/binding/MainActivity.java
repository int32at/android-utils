package at.int32.android.utils.samples.binding;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ViewModel model = new ViewModel();
		model.bind(new ViewHolder(this));
	}
}
