package at.int32.android.utils.sampleapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import at.int32.android.utils.sampleapp.client.Client;
import at.int32.android.utils.sampleapp.client.Client.Type;
import at.int32.android.utils.sampleapp.client.ClientViewHolder;
import at.int32.android.utils.sampleapp.client.ClientViewModel;
import at.int32.android.utils.sampleapp.clock.TimerViewHolder;
import at.int32.android.utils.sampleapp.clock.TimerViewModel;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//SIMPLE TIMER MODEL
		TimerViewModel timer = new TimerViewModel();
		timer.bind(getTimerViewHolder());

		timer.start();
		
		//ADVANCED MODEL
		ClientViewModel model = new ClientViewModel(this, new Client("Andreas", 24));
		model.bind(getViewHolder());
		
		model.enabled(true);
		model.type(Type.ADMIN);
	}

	private ClientViewHolder getViewHolder() {
		ClientViewHolder holder = new ClientViewHolder();

		holder.name = (TextView) findViewById(R.id.name);
		holder.age = (TextView) findViewById(R.id.age);
		holder.enabled = findViewById(R.id.enabled);

		return holder;
	}

	private TimerViewHolder getTimerViewHolder() {
		TimerViewHolder holder = new TimerViewHolder();

		holder.clock = (TextView) findViewById(R.id.clock);

		return holder;
	}
}
