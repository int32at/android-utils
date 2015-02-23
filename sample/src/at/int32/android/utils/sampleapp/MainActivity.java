package at.int32.android.utils.sampleapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import at.int32.android.utils.sampleapp.client.Client;
import at.int32.android.utils.sampleapp.client.ClientViewHolder;
import at.int32.android.utils.sampleapp.client.ClientViewModel;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//create a new model
		ClientViewModel model = new ClientViewModel(new Client("Andreas", 24));
		
		//bind to view holder
		model.bind(getViewHolder());
	}
	
	private ClientViewHolder getViewHolder() {
		ClientViewHolder holder = new ClientViewHolder();
		
		holder.name = (TextView)findViewById(R.id.name);
		holder.age = (TextView)findViewById(R.id.age);
		
		return holder;
	}
}
