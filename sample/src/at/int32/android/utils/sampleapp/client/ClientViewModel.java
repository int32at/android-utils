package at.int32.android.utils.sampleapp.client;

import at.int32.android.utils.ui.binding.ViewModel;
import at.int32.android.utils.ui.binding.bindable.IntegerBindable;
import at.int32.android.utils.ui.binding.bindable.StringBindable;
import at.int32.android.utils.ui.binding.types.TextBinding;

public class ClientViewModel extends ViewModel<ClientViewHolder> {

	private ClientBinding client;
	
	public ClientViewModel(Client actualClient) {
		this.client = new ClientBinding(actualClient);
	}
	
	@Override
	public void bind(ClientViewHolder viewHolder) {

		//bind to view whenever the value of name is changed 
		//TextBinding will set the text of the view
		//initialize will set the value right away (default value), this is optional!
		this.name().bindTo(new TextBinding(viewHolder.name)).initialize();
	}
	
	public StringBindable name() {
		return this.client.name();
	}
	
	public IntegerBindable age() {
		return this.client.age();
	}
}
