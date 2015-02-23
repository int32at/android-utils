package at.int32.android.utils.sampleapp.client;

import android.content.Context;
import at.int32.android.utils.ui.binding.ViewModel;
import at.int32.android.utils.ui.binding.types.VisibilityBinding;

public class ClientViewModel extends ViewModel<ClientViewHolder> {

	private ClientBinding client;
	private Context context;

	public ClientViewModel(Context context, Client actualClient) {
		this.context = context;
		this.client = new ClientBinding(actualClient);
	}

	@Override
	public void bind(ClientViewHolder viewHolder) {

		this.client.name()
				.bindTo(this.client.name().textBinding(viewHolder.name))
				.initialize();

		this.client.age().bindTo(this.client.age().textBinding(viewHolder.age))
				.initialize();

		this.client.enabled().bindTo(new VisibilityBinding(viewHolder.enabled))
				.initialize();

		this.client.type()
				.bindTo(new ClientTypeBinding(this.context, viewHolder.name))
				.initialize();
	}

	public String name() {
		return this.client.name().get();
	}
	
	public void name(String name) {
		this.client.name().set(name);
	}

	public int age() {
		return this.client.age().get();
	}

	public Boolean enabled() {
		return this.client.enabled().get();
	}

	public void enabled(Boolean enabled) {
		this.client.enabled().set(enabled);
	}

	public Client.Type type() {
		return this.client.type().get();
	}

	public void type(Client.Type type) {
		this.client.type().set(type);
	}
}
