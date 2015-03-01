package at.int32.android.utils.ui.binding;

public interface IViewBindable<T, B extends Bindable<T>> {
	public void bindTo(B bindable);

	public void update(T bindable, boolean twoWay);
}
