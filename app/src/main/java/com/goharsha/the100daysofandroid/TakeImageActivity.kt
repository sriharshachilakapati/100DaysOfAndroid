package com.goharsha.the100daysofandroid

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_take_image.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class TakeImageActivity : AppCompatActivity() {
    companion object {
        private const val REQUEST_THUMBNAIL_IMAGE_CAPTURE = 1
        private const val REQUEST_FULL_QUALITY_IMAGE_CAPTURE = 2

        private const val FILE_PROVIDER_AUTHORITY = "${BuildConfig.APPLICATION_ID}.FileProvider"
    }

    private lateinit var onTakeDelegate: () -> Unit
    private lateinit var capturedImagePath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_image)

        takeImageButton.setOnClickListener { onTakeDelegate() }
    }

    private fun onTakeThumbNail() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { intent ->
            intent.resolveActivity(packageManager)?.also {
                startActivityForResult(intent, REQUEST_THUMBNAIL_IMAGE_CAPTURE)
            }
        }
    }

    private fun onTakeFullQuality() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { intent ->
            val photoFile = try {
                createImageFile()
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }

            photoFile?.also {
                val uri = FileProvider.getUriForFile(this, FILE_PROVIDER_AUTHORITY, it)
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
                startActivityForResult(intent, REQUEST_FULL_QUALITY_IMAGE_CAPTURE)
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun createImageFile(): File {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)

        return File.createTempFile("JPEG_${timeStamp}_", ".jpg", storageDir).apply {
            capturedImagePath = absolutePath
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode != Activity.RESULT_OK) {
            return
        }

        val photoBitmap = when (requestCode) {
            REQUEST_THUMBNAIL_IMAGE_CAPTURE -> data?.extras?.get("data") as Bitmap?
            REQUEST_FULL_QUALITY_IMAGE_CAPTURE -> readBitmapFromCamera()
            else -> null
        } ?: return

        pickedImageView.setImageBitmap(photoBitmap)
    }

    private fun readBitmapFromCamera(): Bitmap {
        val photoFile = File(capturedImagePath)
        val uri = FileProvider.getUriForFile(this, FILE_PROVIDER_AUTHORITY, photoFile)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val source = ImageDecoder.createSource(contentResolver, uri)
            return ImageDecoder.decodeBitmap(source)
        } else {
            @Suppress("DEPRECATION")
            return MediaStore.Images.Media.getBitmap(contentResolver, uri)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.takeThumbNails -> onTakeDelegate = ::onTakeThumbNail
            R.id.takeFullQuality -> onTakeDelegate = ::onTakeFullQuality
        }

        item.isChecked = true
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_take_image, menu)
        onOptionsItemSelected(menu!!.findItem(R.id.takeThumbNails))

        return true
    }

    override fun onDestroy() {
        if (!isChangingConfigurations) {
            File(capturedImagePath).delete()
        }

        super.onDestroy()
    }
}