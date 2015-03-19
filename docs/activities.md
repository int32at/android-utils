###Activities and Modules
This component allows you to split an android Acitivity into seperate, non-dependent `Modules` without loosing the flexibility of the actual Activity.
An `Activity` becomes an `BootableActivity` in which you can register multiple modules. 

**Example**

Say we create a new Activity called `ChatActivity` where we would like to display a chat window between 2 users.
```java
public class ChatActivity extends BootableActivity {
	
	@Override
	public void init() {
		register(this, new ChatModule());
		
		//you can even register multiple modules like this:
		//register(this, new ChatModule(), new NetworkModule(), new BlaBlaModule());
	}
}
```

Now we create the `Module`.
```java
public class ChatModule extends ActivityModule {

	@Override
	public void onCreate() {
		//code here
	}
}
```

A `Module` can have the following overrides:
* onStart
* onStop
* onCreate
* onPause
* onResume
* onBackPressed
* onActivityResult

**Note**: The whole purpose of `BootableActivities` and `Modules` is to simplify the code which normally would be in the Activity itself. Instead of having a ton of code in the Activity itself, you can move it to several and seperate `Modules` which makes your code easier to understand, read and write! 
