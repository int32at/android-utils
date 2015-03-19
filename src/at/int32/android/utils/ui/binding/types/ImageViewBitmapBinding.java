package at.int32.android.utils.ui.binding.types;

import android.graphics.Bitmap;
import android.widget.ImageView;
import at.int32.android.utils.ui.binding.Binding;

public class ImageViewBitmapBinding extends Binding<Bitmap, ImageView>{

	public ImageViewBitmapBinding(ImageView... views) {
		super(views);
	}
	
	@Override
	public void run(Bitmap data, ImageView view) {
		if(view != null) {
			view.setImageBitmap(data);
		}
	}

}
