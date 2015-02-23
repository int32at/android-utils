package at.int32.android.utils.sampleapp.client;

public class Client {
	private String name;
	private int age;

	public Client(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String name() {
		return this.name;
	}

	public int age() {
		return this.age;
	}
}
