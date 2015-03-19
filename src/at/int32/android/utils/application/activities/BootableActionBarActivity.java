package at.int32.android.utils.application.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import at.int32.android.utils.application.modules.ActionBarActivityModule;

public abstract class BootableActionBarActivity extends ActionBarActivity
		implements IBootableActivity {

	private BootableHelper<ActionBarActivity> helper = new BootableHelper<ActionBarActivity>();
	
	public BootableActionBarActivity() {
		init();
	}

	public void register(ActionBarActivity activity, ActionBarActivityModule... modules) {
		helper.register(activity, modules);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		helper.onCreate();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		helper.onResume();
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		helper.onStart();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		helper.onStop();
	}
}
