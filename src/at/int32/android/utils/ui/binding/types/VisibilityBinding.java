package at.int32.android.utils.ui.binding.types;

import android.view.View;
import at.int32.android.utils.ui.binding.Binding;

public class VisibilityBinding extends Binding<Boolean, View> {

	public enum Direction {
		NORMAL,
		REVERSE
	}
	
	private Direction direction;
	
	public VisibilityBinding(View... views) {
		this(Direction.NORMAL, views);
	}
	
	public VisibilityBinding(Direction direction, View view) {
		super(view);
		this.direction = direction;
	}
	
	public VisibilityBinding(Direction direction, View... views) {
		super(views);
		this.direction = direction;
	}

	@Override
	public void run(Boolean visible, View view) {
		if (view == null)
			return;
		
		if(direction == Direction.NORMAL) 
			view.setVisibility(visible ? View.VISIBLE : View.GONE);
		else
			view.setVisibility(!visible ? View.VISIBLE : View.GONE);
	}
}
