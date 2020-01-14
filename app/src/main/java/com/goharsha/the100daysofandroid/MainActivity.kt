package com.goharsha.the100daysofandroid

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

typealias LauncherModel = Class<out AppCompatActivity>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contents = mapOf(
            TestActivity::class.java to "Test Activity",
            PhotoGalleryActivity::class.java to "Photo Gallery with Drawables",
            PickImageActivity::class.java to "Image Picker",
            AnimalInfoActivity::class.java to "Animal Info with Fragment"
        )

        launcherListView.adapter = LauncherItemAdapter(this, contents)
    }

    private class LauncherItemAdapter(context: Context, private val contents: Map<LauncherModel, String>) :
        ArrayAdapter<LauncherModel>(context, R.layout.launcher_item, contents.keys.toTypedArray()) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(context).inflate(
                R.layout.launcher_item,
                parent,
                false
            )

            val activity = getItem(position)!!
            val text = contents[activity]

            view.apply {
                findViewById<TextView>(R.id.launcherItemName).text = context.resources
                    .getString(R.string.launcher_item_name_text)
                    .format(position + 1, text)

                setOnClickListener {
                    val intent = Intent(context, activity)
                    context.startActivity(intent)
                }
            }

            return view
        }
    }
}
