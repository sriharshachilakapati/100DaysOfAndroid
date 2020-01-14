# 100 Days of Android

This repo is used to track 100 days of Android.

## Day 1

Day 1 is for setting up, where I create an activity that allows me to launch the sub-app for each day's activity. A list view in an activity is enough.

### What I learnt

- Different views, used `LinearLayout`, `TextView` and `ConstraintLayout`
- Creating lists in Kotlin (`listOf` can take generic type parameters instead of inference)
- How to use `ArrayAdapter` to easily create `ListView`s with content
- Kotlin generics (Especially `out` condition to specify upper bounds)
- `!!` operator can be used to annotate a type that it is not nullable
- The Elvis operator `(?:)` of Kotlin that can be used to provide alternative if in case of `null`
- Creating an `Intent` and using `startActivity()` to start another activity

## Day 2

The plan is to create a photo gallery with Grid layout manager and RecyclerView.

### What I learnt

- Different views like `RecyclerView` and `CardView`
- How to use `RecyclerView` as a `GridView`
- Kotlin inner classes, and how they are different from Java's inner classes
- Kotlin's `let`, `with`, `apply` and `also` functions
- Kotlin function expressions
- Using images stored as drawables

## Day 3

This time I plan to learn picking images using an `Intent`, and display it in an `ImageView`. The idea is to find the path from the picker, read it into a `Bitmap` and show that in an `ImageView`.

### What I learnt

- Creating intent with a type and action
- Chooser intents
- Responding to result of another activity with `onActivityResult`
- Using `android:layout_weight` attribute to fill available space
- Two ways of reading a bitmap from a `URI` using `ImageDecoder` and `MediaStore`
- Function references in Kotlin
- Kotlin's `@Suppress` annotation
- Launching an activity using <kbd>Ctrl</kbd>+<kbd>Shift</kbd>+<kbd>F10</kbd> is possible if `android:exported="true"` is specified

## Day 4

Today I wanted to explore fragments. The idea is to have a fragment that shows content, and have menu in the activity to send events to the fragment.

### What I learnt

- Fragments and their lifecycle. A shout-out to [xxv/android-lifecycle](https://github.com/xxv/android-lifecycle) for the diagram reference
- Using the fragment support manager. We can also use the `<fragment>` tag in XML, but save it for later
- Creating menu resources
- Array resource files. Learned about string arrays are typed arrays
- Creating a `Spinner` in a `MenuItem`
- Kotlin's `lateinit` keyword allowing to initialize a value later
- Scrolling with `ScrollView`

## Day 5, 6 and 7

I couldn't continue because of work. But still, I'm glad that I used fragments in real work, which I learnt of Day 4. My reading has continued though.

### What I learnt

- Maps in Kotlin. I have modified the launcher to show customized text instead of simply displaying the activity name.
- Type aliases. Use them to shorten out types. Would've been better if local or scoped aliases are supported though.
- Using `tools:ignore` in layout XML files.

## Day 8

A few days were spent in work and other personal stuff. Now am resuming the day 8, and today's plan is to do the Image Picker part 2, where instead of picking from the gallery, we take from camera.

### What I learnt

- How to invoke the Camera app via intent, and to take a thumbnail
- How to ask the Camera app to write to a file (not shown in Gallery)
- Using the Android's `FileProvider` class
- How content providers work in Android
- Kotlin's built-in `Pair` generic data class
- Kotlin's string-interpolation
- Using radio buttons in menu items
- How Permissions work in Android and how features are used by the Play Store
- Using XML resources in Android
- Using Lambdas and Function References to create delegates (Idea from C#)