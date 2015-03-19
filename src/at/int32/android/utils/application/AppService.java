package at.int32.android.utils.application;

import android.app.Service;
import android.content.Intent;

public abstract class AppService extends Service {
	
	private boolean isRunning = false;
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		isRunning = true;
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		isRunning = false;
		super.onDestroy();
	}
	
	public boolean isRunning() {
		return isRunning;
	}

}
