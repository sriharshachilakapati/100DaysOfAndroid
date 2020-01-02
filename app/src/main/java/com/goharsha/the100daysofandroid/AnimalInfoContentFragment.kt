package com.goharsha.the100daysofandroid

import android.content.res.TypedArray
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_animal_info_content.*

class AnimalInfoContentFragment : Fragment(R.layout.fragment_animal_info_content) {
    private lateinit var contents: Array<String>
    private lateinit var images: TypedArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contents = resources.getStringArray(R.array.image_drawable_names)
        images = resources.obtainTypedArray(R.array.image_drawables)
    }

    override fun onDestroy() {
        images.recycle()
        super.onDestroy()
    }

    fun selectionChange(position: Int) {
        animalInfoFragmentCoverImage.setImageDrawable(images.getDrawable(position))
        animalInfoFragmentContentTitle.text = contents[position]
    }
}