# 100 Days of Android

This repo is used to track 100 days of Android.

## Day 1

Day 1 is for setting up, where I create an activity that allows me to launch the sub-app for each day's activity. A list view in an activity is enough.

### What I learned

- Different views, used `LinearLayout`, `TextView` and `ConstraintLayout`
- Creating lists in Kotlin (`listOf` can take generic type parameters instead of inference)
- How to use `ArrayAdapter` to easily create `ListView`s with content
- Kotlin generics (Especially `out` condition to specify upper bounds)
- `!!` operator can be used to annotate a type that it is not nullable
- The Elvis operator `(?:)` of Kotlin that can be used to provide alternative if in case of `null`
- Creating an `Intent` and using `startActivity()` to start another activity

## Day 2

The plan is to create a photo gallery with Grid layout manager and RecyclerView.

### What I learned

- Different views like `RecyclerView` and `CardView`
- How to use `RecyclerView` as a `GridView`
- Kotlin inner classes, and how they are different from Java's inner classes
- Kotlin's `let`, `with`, `apply` and `also` functions
- Kotlin function expressions
- Using images stored as drawables

## Day 3

This time I plan to learn picking images using an `Intent`, and display it in an `ImageView`. The idea is to find the path from the picker, read it into a `Bitmap` and show that in an `ImageView`.

### What I learned

- Creating intent with a type and action
- Chooser intents
- Responding to result of another activity with `onActivityResult`
- Using `android:layout_weight` attribute to fill available space
- Two ways of reading a bitmap from a `URI` using `ImageDecoder` and `MediaStore`
- Function references in Kotlin
- Kotlin's `@Suppress` annotation
- Launching an activity using <kbd>Ctrl</kbd>+<kbd>Shift</kbd>+<kbd>F10</kbd> is possible if `android:exported="true"` is specified

