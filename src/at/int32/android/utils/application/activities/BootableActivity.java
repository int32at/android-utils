package at.int32.android.utils.application.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import at.int32.android.utils.application.modules.ActivityModule;

public abstract class BootableActivity extends Activity implements IBootableActivity {
	private BootableHelper<Activity> helper = new BootableHelper<Activity>();

	public BootableActivity() {
		init();
	}
	
	public void register(Activity activity, ActivityModule... modules) {
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
	
	@Override
	protected void onPause() {
		super.onPause();
		helper.onPause();
	}
	
	@Override
	public void onBackPressed() {
		//we dont want super to be called, otherwise it will fire our helper.onBackPressed but close the activity anyway
		//so if we went our activity to be closed, we must override the this method and call finish() ourselves...
		//super.onBackPressed();
		helper.onBackPressed();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		helper.onActivityResult(requestCode, resultCode, data);
	}
}