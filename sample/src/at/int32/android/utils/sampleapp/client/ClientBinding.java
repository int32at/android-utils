package at.int32.android.utils.sampleapp.client;

import at.int32.android.utils.ui.binding.Bindable;
import at.int32.android.utils.ui.binding.bindable.IntegerBindable;
import at.int32.android.utils.ui.binding.bindable.StringBindable;

public class ClientBinding extends Bindable<Client> {

	private StringBindable name;
	private IntegerBindable age;
	
	public ClientBinding(Client client) {
		super(client);
		
		this.name = new StringBindable(client.name());
		this.age = new IntegerBindable(client.age());
	}
	
	public StringBindable name() {
		return this.name;
	}
	
	public IntegerBindable age() {
		 return this.age;
	}
}
