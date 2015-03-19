package at.int32.android.utils.application.activities;

import android.app.Activity;
import android.content.Intent;
import at.int32.android.utils.application.GenericBootloader;
import at.int32.android.utils.application.GenericModule;
import at.int32.android.utils.application.IGenericActivity;

public class BootableHelper<T extends Activity> implements IGenericActivity<T> {
	
	protected GenericBootloader<T> boot;

	public BootableHelper() {
		boot = new GenericBootloader<T>();
	}

	protected void register(T activity, GenericModule<T>... modules) {	
		boot.register(activity, modules);
	}

	@Override
	public void onStart() {
		boot.onStart();
	}

	@Override
	public void onStop() {
		boot.onStop();
	}

	@Override
	public void onCreate() {
		boot.onCreate();
	}

	@Override
	public void onResume() {
		boot.onResume();
	}
	
	@Override
	public void onPause() {
		boot.onPause();
	}

	@Override
	public void onBackPressed() {
		boot.onBackPressed();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		boot.onActivityResult(requestCode, resultCode, data);
	}

}
