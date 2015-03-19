android-utils
=============
[![gradle](https://img.shields.io/github/tag/int32at/android-utils.svg?label=gradle)](https://jitpack.io/#int32at/android-utils/v1.0.2)
[![maveh](https://img.shields.io/github/tag/int32at/android-utils.svg?label=maven)](https://jitpack.io/#int32at/android-utils/v1.0.2)

android-utils is a simple, small and fast framework for Android. It includes the following features:

* [UI Binding](docs/binding.md) - Supports **One-Way** (Model -> View or Model <- View) and **Two-Way** (Model <-> View) Binding. Allows you to bind objects, so called `Bindables`, to any kind of view and update the UI when those objects change. You can set the text of TextView's, change the background color or write your own `Bindings` which allows you to customize the UI actions.

###Download JAR
* [Release 1.0.2](https://github.com/int32at/android-utils/raw/master/releases/android-utils-1.0.2.jar)
    * made two-way binding a lot easier by using the default android controls instead of custom ones!
    * added BindableSeekBar
    * added SeekBar, Bitmap and Disabled Bindings
    * added DateBindable


* [Release 1.0.1](https://github.com/int32at/android-utils/raw/master/releases/android-utils-1.0.1.jar)
    * implemented Two-Way-Binding
    * added BindableEditText & BindableNumberPicker controls
    * added NumberPicker, Focus, Foreground Color & Background Resource/Drawable Bindings
    * added Float, Bitmap & Drawable Bindables


* [Release 1.0.0](https://github.com/int32at/android-utils/raw/master/releases/android-utils-1.0.0.jar) - initial release, first version of UI binding
