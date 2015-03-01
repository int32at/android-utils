package at.int32.android.utils.bus;

public class Event<T> {
	private T data;

	public Event(T data) {
		this.data = data;
	}

	public T data() {
		return this.data;
	}
}
