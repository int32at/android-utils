package at.int32.android.utils.sampleapp.client;

public class Client {

	public enum Type {
		USER, ADMIN
	}

	private String name;
	private int age;
	private boolean enabled;
	private Client.Type type;

	public Client(String name, int age) {
		this.name = name;
		this.age = age;
		this.enabled = false;
		this.type = Type.USER;
	}

	public String name() {
		return this.name;
	}

	public int age() {
		return this.age;
	}

	public boolean enabled() {
		return this.enabled;
	}

	public void enabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Type type() {
		return this.type;
	}

	public void type(Type type) {
		this.type = type;
	}
}
