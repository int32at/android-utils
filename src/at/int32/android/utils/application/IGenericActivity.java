package at.int32.android.utils.application;

import android.app.Activity;
import android.content.Intent;

public interface IGenericActivity<T extends Activity> {
	public void onStart();

	public void onStop();

	public void onCreate();

	public void onResume();
	
	public void onPause();
	
	public void onBackPressed();

	public void onActivityResult(int requestCode, int resultCode, Intent data);
	
}
