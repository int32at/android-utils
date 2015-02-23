package at.int32.android.utils.sampleapp.client;

import android.R;
import android.content.Context;
import android.widget.TextView;
import at.int32.android.utils.ui.binding.BindingRunnable;

public class ClientTypeBinding extends BindingRunnable<ClientType, TextView> {

	private Context context;

	public ClientTypeBinding(Context context, TextView... views) {
		super(views);
		this.context = context;
	}

	@Override
	public void run(ClientType data) {
		int color = -1;

		if (data == ClientType.ADMIN)
			color = R.color.black;
		else if (data == ClientType.USER)
			color = R.color.darker_gray;

		for (TextView view : getViews()) {
			view.setTextColor(context.getResources().getColor(color));
		}
	}
}
