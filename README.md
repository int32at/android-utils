android-utils
=============

android-utils is a simple, small and fast framework for Android. It includes the following features:

* UI Binding (One-Way, Two-Way is wip)


###UI Binding

I know i know, yet another UI binding library for Android. The reason i created this component was simple due to the fact that no other library felt easy to use, and easy to integrate in an existing codebase. I took the following approach:

Binding consists of the following 3 pieces:
* **Bindable**: object that holds the value and notifies when it's changed
* **View Holder**: object that holds references to views
* **View Model**: object that does the actual business logic


####Example
If you don't wish to go through the tutorial right now, you can also see the [existing examples](sample/src/at/int32/android/utils/sampleapp).

* [Timer](sample/src/at/int32/android/utils/sampleapp/clock) - a small implementation of a timer (clock)
* [Client](sample/src/at/int32/android/utils/sampleapp/client) - a more advanced example 

We start of by creating a new `View Holder` class.

```java
public class UserViewHolder implements IViewHolder {
    public TextView name;
}
```
Now lets create a new object from our `View Holder` and reference the views we want to update.

```java
UserViewHolder viewHolder = new UserViewHolder();
viewHolder.name = (TextView) findViewById(R.id.tv_name);
```

And now create the `View Model`. We can add a `Bindable` called **name** to it - this will be our object that updates the UI when it's value is changed.

```java
public class UserViewModel extends ViewModel<UserViewHolder> {

    public StringBindable name = new StringBindable();

    @Override
    public void bind(UserViewHolder viewHolder) {
        //todo: implement (see next step)
    }
}
```

We are pretty much set up. Now we can do the actual binding which is also pretty straight forward. Consider the bind method of the `View Model` we just created.

```java
@Override
public void bind(UserViewHolder viewHolder) {
    //see the bindings section for more binding types!
    
    this.name.bindTo(new TextBinding<String>(viewHolder.name));
}
```
**That's it!** Whenever the value of `name` is changed using it's `set(String data)` method, the view `R.id.tv_name` will be updated. Since we bound a TextBinding<String> to this view, obviously the text will be changed. Like this:

```java
UserViewModel model = new UserViewModel();

//set the name, updates the ui
model.name.set("andreas");

####Bindables
There are multiple types of `Bindables` that are shipped with android-utils, but you could easily write your own.

* **StringBindable**
* **IntegerBindable**
* **BooleanBindable**

**Writing your own**

You can write your own by extending the `BindingRunnable<T, View>` object. An example:
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
name.bindTo(viewHolder.name, viewHolder.name1, ViewHolder.name3);
```

Whenever `name` is updated, it updates all 3 views! How neat is that?

####Bindings
Just like `Bindables`, there are also different implementations of Bindings that are comming with this framework.

* **TextBinding**: sets the text of a text view
* **TextColorBinding**: sets the front color of a text view
* **BackgroundColorBinding**: sets the background color of a view
* **VisibilityBinding**: sets the visibility (view, gone) of a view

**Writing your own**
```java
public class ClientTypeBinding extends BindingRunnable<Client.Type, TextView> {

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
