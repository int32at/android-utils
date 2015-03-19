package at.int32.android.utils.application.context;

import android.content.Context;

public abstract class ContextAwareObject {
	private Context context;
	
	public ContextAwareObject(Context context) {
		this.context = context;
	}
	
	public Context context() {
		return context;
	}
}
