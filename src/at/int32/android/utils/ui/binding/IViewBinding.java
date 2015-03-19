package at.int32.android.utils.ui.binding;

public interface IViewBinding<T, B extends Bindable<T>> {
	public void bindTo(Bindable<T> bindable);
	public void update(T data, boolean twoWay);
}
