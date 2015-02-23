package at.int32.android.utils.ui.binding;

import java.util.HashMap;
import java.util.Map;

public class ViewModelHolder {

	private static Map<Class<? extends ViewModel<? extends IViewHolder>>, ViewModel<? extends IViewHolder>> 
		viewModels = new HashMap<Class<? extends ViewModel<? extends IViewHolder>>, ViewModel<? extends IViewHolder>>();

	@SuppressWarnings("unchecked")
	public static void add(ViewModel<? extends IViewHolder> viewModel) {
		viewModels.put((Class<? extends ViewModel<? extends IViewHolder>>) viewModel.getClass(), viewModel);
	}

	public static ViewModel<? extends IViewHolder> get(
			Class<? extends ViewModel<? extends IViewHolder>> viewModelClass) {
		return viewModels.get(viewModelClass);
	}
}
