###UI Binding
The UI Binding component of this library allows you to specify bindable objects that can be bound to any kind of view. You can choose between 2 modes:

* **One-Way Binding**: this mode allows you to update the UI of your app whenever a `Bindable` is changed (Model -> View).

* **Two-Way (Bidirectional) Binding**: this mode will update the `bindables` whenever the view is changed and vice-versa. (Model <-> View). Obviously, you could also just make the view bind to the model (Model <- View).

####Examples

* [UI Binding](/samples/sample_binding/src/at/int32/android/utils/samples/binding) - simple view model with 2 bindables and Two-Way-Binding enabled.

One-Way Binding
```java
//create a new binding (see bindable section for more info)
StringBindable name = new StringBindable();

//bind to text view using the TextBinding (will set the text of the TextView)
//for more bindings see the binding section
name.bindTo(new TextBinding<String>((TextView)findViewById(R.id.tv_name)));

//set the value, which updates the textview automatically
name.set("andreas");
```

Two-Way Binding
```java
StringBindable name = new StringBindable();

//get the bindable edittext (custom control)
BindableEditText edit = (BindableEditText) findViewById(R.id.edit_name);

//bind view to model
edit.bindTo(name);

//bind model to view
name.bindTo(new TextBinding<String>(edit));

//the view will now have a default value, and whenever it's changed (through user input) the model will update aswell!
name.set("andreas");

```

####Bindables
There are multiple types of `Bindables` that are shipped with android-utils, but you could easily write your own.

* **StringBindable**
* **IntegerBindable**
* **BooleanBindable**
* **FloatBindable**
* **DrawableBindable**
* **BitmapBindable**

**Writing your own**

**Default Value**: `Bindables` can also have an default value (which can update the UI aswell if you want).

```java
//set the default value
IntegerBindable age = new IntegerBindable(24);

//bind to model
age.bindTo(viewHolder.age);

//initialize (updates the view, without having to manually call the .set() method
age.initialize();
```

You can write your own by extending the `Bindable<T>` object. An example:
```java
public class UUIDBindable extends Bindable<UUID> {
	public UUIDBindable() {
		super();
	}

	public UUIDBindable(UUID id) {
        super(id);
	}
}
```
Another interesting fact about `Bindables` is that you can bind them to **multiple** views!

```java
name.bindTo(viewHolder.name, viewHolder.name1, viewHolder.name3);
```

Whenever `name` is updated, it updates all 3 views! How neat is that?

####Bindings
Just like `Bindables`, there are also different implementations of Bindings that are comming with this framework.

* **TextBinding**: sets the text of a text view
* **TextColorBinding**: sets the front color of a text view
* **BackgroundColorBinding**: sets the background color of a view
* **VisibilityBinding**: sets the visibility (view, gone) of a view
* **NumberPickerBinding**: sets the (integer) value of a number picker
* **ForegroundColorBinding**: sets the foreground (text) color of a text view
* **FocusBinding**: sets the focus of a view
* **BackgroundResourceBinding**: sets the background resource of a view
* **BackgroundDrawableBinding**: sets the background drawable of a view

**Writing your own**
```java
public class ClientTypeBinding extends Binding<Type, TextView> {

	private Context context;

	public ClientTypeBinding(Context context, TextView... views) {
		super(views);
		this.context = context;
	}

	@Override
	public void run(Type data) {
		int color = -1;

		if (data == Type.ADMIN)
			color = R.color.black;
		else if (data == Type.USER)
			color = R.color.darker_gray;

		for (TextView view : getViews()) {
			view.setTextColor(context.getResources().getColor(color));
		}
	}
}
```
