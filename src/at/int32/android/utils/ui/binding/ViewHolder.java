package at.int32.android.utils.ui.binding;

import android.app.Activity;

public abstract class ViewHolder implements IViewHolder {
	private Activity activity;

	public ViewHolder(Activity activity) {
		this.activity = activity;
	}

	public Activity activity() {
		return activity;
	}
}
