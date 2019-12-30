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