package at.int32.android.utils.sampleapp.clock;

import java.text.SimpleDateFormat;
import java.util.Date;

import at.int32.android.utils.thread.Threading;
import at.int32.android.utils.ui.binding.ViewModel;
import at.int32.android.utils.ui.binding.bindable.StringBindable;
import at.int32.android.utils.ui.binding.types.TextBinding;

public class TimerViewModel extends ViewModel<TimerViewHolder> {

	private StringBindable time;

	public TimerViewModel() {
		time = new StringBindable();
	}

	@Override
	public void bind(TimerViewHolder viewHolder) {
		this.time.bindTo(new TextBinding<String>(viewHolder.clock));
	}

	public void start() {
		Threading.runEvery(new Runnable() {

			@Override
			public void run() {
				time.set(new SimpleDateFormat("HH:mm:ss").format(new Date()));
			}
			
		}, 1000);
	}
}
