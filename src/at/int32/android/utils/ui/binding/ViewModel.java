package at.int32.android.utils.ui.binding;

public abstract class ViewModel<T extends IViewHolder> {

	public abstract void bind(T viewHolder);

}
