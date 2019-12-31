package com.goharsha.the100daysofandroid

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_photo_gallery.*

class PhotoGalleryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_gallery)
        title = "Day 2: Photo Gallery"

        val data = listOf(
            "image_1",
            "image_2",
            "image_3",
            "image_4",
            "image_5"
        )

        photoGalleryRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@PhotoGalleryActivity, 2)
            adapter = GalleryCellAdapter(this@PhotoGalleryActivity, data)
        }
    }

    class GalleryCellAdapter(private val context: Context, private val data: List<String>) :
        RecyclerView.Adapter<GalleryCellAdapter.ViewHolder>() {

        class ViewHolder(val galleryCell: View) : RecyclerView.ViewHolder(galleryCell)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(context)
                    .inflate(R.layout.photo_gallery_cell, parent, false)
            )
        }

        override fun getItemCount(): Int = data.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.galleryCell.apply {
                val imageView = findViewById<ImageView>(R.id.photoGalleryCellImageView)
                val imageSource = data[position]

                val imageResource = context.resources.getIdentifier(imageSource, "drawable", context.packageName)
                imageView.setImageDrawable(context.getDrawable(imageResource))
            }
        }
    }
}