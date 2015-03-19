package at.int32.android.utils.application;

import android.app.Activity;

public abstract class GenericModule<T extends Activity> implements
		IGenericActivity<T> {
	private T activity;

	public T activity() {
		return activity;
	}

	public void activity(T activity) {
		this.activity = activity;
	}

}
