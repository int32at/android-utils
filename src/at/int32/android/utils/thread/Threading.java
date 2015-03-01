package at.int32.android.utils.thread;

import android.os.Handler;

public class Threading {

	private static Handler handler = new Handler();

	public static void runEvery(final Runnable r, final int milliseconds) {

		new Thread(new Runnable() {
			@Override
			public void run() {

				while (true) {

					try {
						handler.post(r);
						Thread.sleep(milliseconds);

					} catch (Exception e) {
					}
				}
			}
		}).start();

	}
}
