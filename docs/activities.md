###Activities and Modules
This component allows you to split an android Acitivity into seperate, non-dependent `Modules` without loosing the flexibility of the actual Activity.
An `Activity` becomes an `BootableActivity` in which you can register multiple modules. 

Example

```java
public class ChatActivity extends BootableActivity {
	
	@Override
	public void init() {
		register(this, new ChatModule());
	}
}

```
