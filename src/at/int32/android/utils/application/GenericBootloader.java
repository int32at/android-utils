package at.int32.android.utils.application;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;

public class GenericBootloader<T extends Activity> implements IGenericActivity<T> {
	private ArrayList<GenericModule<T>> modules;

	public GenericBootloader() {
		this.modules = new ArrayList<GenericModule<T>>();
	}

	public void register(T activity, GenericModule<T>... modules) {
		
		for(GenericModule<T> module : modules)
			module.activity(activity);
		
		this.modules.addAll(Arrays.asList(modules));
	}

	@Override
	public void onStart() {
		for (GenericModule<T> module : modules)
			module.onStart();
	}

	@Override
	public void onStop() {
		for (GenericModule<T> module : modules)
			module.onStop();
	}

	@Override
	public void onCreate() {
		for (GenericModule<T> module : modules)
			module.onCreate();
	}

	@Override
	public void onResume() {
		for (GenericModule<T> module : modules)
			module.onResume();
	}
	
	@Override
	public void onPause() {
		for (GenericModule<T> module : modules)
			module.onPause();
	}

	@Override
	public void onBackPressed() {
		for (GenericModule<T> module : modules)
			module.onBackPressed();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		for (GenericModule<T> module : modules)
			module.onActivityResult(requestCode, resultCode, data);
	}
}
