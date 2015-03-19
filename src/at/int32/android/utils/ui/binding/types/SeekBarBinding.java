package at.int32.android.utils.ui.binding.types;

import android.widget.SeekBar;
import at.int32.android.utils.ui.binding.Binding;

public class SeekBarBinding extends Binding<Integer, SeekBar>{

	public SeekBarBinding(SeekBar... views) {
		super(views);
	}
	
	@Override
	public void run(Integer data, SeekBar view) {
		view.setProgress(data);
	}

}
