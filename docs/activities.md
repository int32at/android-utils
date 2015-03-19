###Activities and Modules
This component allows you to split an android Acitivity into seperate, non-dependent `Modules` without loosing the flexibility of the actual Activity.
An `Activity` becomes an `BootableActivity` in which you can register multiple modules. 

Example

Say we create a new Activity called `ChatActivity` where we would like to display a chat window between 2 users.
```java
public class ChatActivity extends BootableActivity {
	
	@Override
	public void init() {
		register(this, new ChatModule());
	}
}
```

Now we create the `Module`
```java
public class ChatModule extends ActivityModule {

	@Override
	public void onCreate() {
		//code here
	}
}


```
