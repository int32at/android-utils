package at.int32.android.utils.sampleapp.client;

import android.content.Context;
import at.int32.android.utils.ui.binding.Bindable;
import at.int32.android.utils.ui.binding.ViewModel;
import at.int32.android.utils.ui.binding.bindable.BooleanBindable;
import at.int32.android.utils.ui.binding.bindable.IntegerBindable;
import at.int32.android.utils.ui.binding.bindable.StringBindable;
import at.int32.android.utils.ui.binding.types.VisibilityBinding;

public class ClientViewModel extends ViewModel<ClientViewHolder> {

	private Context context;

	private StringBindable name;
	private IntegerBindable age;
	private BooleanBindable enabled;
	private ClientTypeBindable type;

	public ClientViewModel(Context context) {
		this.context = context;

		this.name = new StringBindable("andreas");
		this.age = new IntegerBindable(24);
		this.enabled = new BooleanBindable(true);
		this.type = new ClientTypeBindable(ClientType.ADMIN);
	}

	@Override
	public void bind(ClientViewHolder viewHolder) {

		this.name.bindTo(this.name.textBinding(viewHolder.name)).initialize();

		this.age.bindTo(this.age.textBinding(viewHolder.age)).initialize();

		this.enabled.bindTo(new VisibilityBinding(viewHolder.enabled))
				.initialize();

		this.type.bindTo(new ClientTypeBinding(this.context, viewHolder.name))
				.initialize();
	}

	public String name() {
		return this.name.get();
	}

	public void name(String name) {
		this.name.set(name);
	}

	public int age() {
		return this.age.get();
	}

	public Boolean enabled() {
		return this.enabled.get();
	}

	public void enabled(Boolean enabled) {
		this.enabled.set(enabled);
	}

	public ClientType type() {
		return this.type.get();
	}

	public void type(ClientType type) {
		this.type.set(type);
	}

	public class ClientTypeBindable extends Bindable<ClientType> {

		public ClientTypeBindable() {
			super();
		}

		public ClientTypeBindable(ClientType type) {
			super(type);
		}
	}
}
