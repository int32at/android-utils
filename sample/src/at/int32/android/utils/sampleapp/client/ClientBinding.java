package at.int32.android.utils.sampleapp.client;

import at.int32.android.utils.ui.binding.Bindable;
import at.int32.android.utils.ui.binding.bindable.BooleanBindable;
import at.int32.android.utils.ui.binding.bindable.IntegerBindable;
import at.int32.android.utils.ui.binding.bindable.StringBindable;

public class ClientBinding extends Bindable<Client> {

	private StringBindable name;
	private IntegerBindable age;
	private BooleanBindable enabled;
	private ClientTypeBindable type;

	public ClientBinding(Client client) {
		super(client);

		this.name = new StringBindable(client.name());
		this.age = new IntegerBindable(client.age());
		this.enabled = new BooleanBindable(client.enabled());
		this.type = new ClientTypeBindable(client.type());
	}

	public StringBindable name() {
		return this.name;
	}

	public IntegerBindable age() {
		return this.age;
	}

	public BooleanBindable enabled() {
		return this.enabled;
	}

	public ClientTypeBindable type() {
		return this.type;
	}

	public class ClientTypeBindable extends Bindable<Client.Type> {

		public ClientTypeBindable() {
			super();
		}

		public ClientTypeBindable(Client.Type type) {
			super(type);
		}
	}
}
