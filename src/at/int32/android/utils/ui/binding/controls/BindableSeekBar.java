package at.int32.android.utils.ui.binding.controls;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import at.int32.android.utils.ui.binding.Bindable;
import at.int32.android.utils.ui.binding.IViewBinding;

public class BindableSeekBar implements IViewBinding<Integer, Bindable<Integer>>{

	private SeekBar seek;
	private Bindable<Integer> bindable;
	
	public BindableSeekBar(SeekBar seek) {
		this.seek = seek;
		
		this.seek.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				if(bindable != null)
					bindable.set(progress, true);
			}
		});
	}
	
	@Override
	public void bindTo(Bindable<Integer> bindable) {
		this.bindable = bindable;
	}

	@Override
	public void update(Integer data, boolean twoWay) {
		if(!twoWay)
			seek.setProgress(data);
	}

}
