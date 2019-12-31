package com.goharsha.the100daysofandroid

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = listOf(
            TestActivity::class.java,
            PhotoGalleryActivity::class.java
        )

        launcherListView.adapter =
            object : ArrayAdapter<Class<out AppCompatActivity>>(this, R.layout.launcher_item, items) {
                override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                    val view = convertView ?: LayoutInflater.from(this@MainActivity).inflate(
                        R.layout.launcher_item,
                        parent,
                        false
                    )
                    val activity = getItem(position)!!

                    val textView = view.findViewById<TextView>(R.id.launcherItemName)
                    textView.text = this@MainActivity.resources
                        .getString(R.string.launcher_item_name_text)
                        .format(position + 1, activity.simpleName)

                    view.setOnClickListener {
                        val intent = Intent(this@MainActivity, activity)
                        startActivity(intent)
                    }

                    return view
                }
            }
    }
}
