//CPSC 411 Project
//Image Editor App
//Kenji Uchida & Quang Nguyen

package com.example.imageeditor

//Import statements
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

//Main activity
class MainActivity : AppCompatActivity() {
    //instantiate variables
    private lateinit var appImage: ImageView
    private lateinit var bitmapOriginal: Bitmap
    private lateinit var bitmapEdit: Bitmap
    private lateinit var bitmapEdit2: Bitmap

    //override method of onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        //Call parent method onCreate
        super.onCreate(savedInstanceState)

        //set view for activity design
        setContentView(R.layout.activity_main)

        //initialize image
        appImage = findViewById<ImageView>(R.id.appImage)

        //wraps image into Bitmap object
        val bitmapDrawable = appImage?.drawable as BitmapDrawable

        //saves original state
        bitmapOriginal = bitmapDrawable.bitmap
        bitmapEdit = bitmapDrawable.bitmap
        bitmapEdit2 = bitmapDrawable.bitmap
    }

    //reset ImageView to original Bitmap
    fun resetClicked(view: View?) {
        appImage.setScaleY(1f)
        appImage.setScaleX(1f)
        appImage!!.setImageBitmap(bitmapOriginal)
    }

    //method to rotate image using Matrix
    fun rotateClicked(view: View?) {
        //wraps image into Bitmap object
        val bitmapDrawable = appImage?.drawable as BitmapDrawable
        bitmapEdit = bitmapDrawable.bitmap

        var matrix = Matrix()
        matrix.postRotate(90f)
        bitmapEdit = Bitmap.createBitmap(bitmapEdit, 0, 0, bitmapEdit.getWidth(), bitmapEdit.getHeight(), matrix, true);
        bitmapEdit2 = bitmapEdit
        appImage!!.setImageBitmap(bitmapEdit)
    }

    //method to enhance image RGB
    fun brightClicked(view: View?) {
        bitmapEdit = Bitmap.createBitmap(bitmapEdit2.width, bitmapEdit2.height, bitmapEdit2.config)

        for (i in 0 until bitmapEdit2.width) {
            for (j in 0 until bitmapEdit2.height) {
                val p = bitmapEdit2.getPixel(i, j)
                var r = Color.red(p)
                var g = Color.green(p)
                var b = Color.blue(p)
                var alpha = Color.alpha(p)
                r = 100 + r
                g = 100 + g
                b = 100 + b
                alpha = 100 + alpha
                bitmapEdit.setPixel(i, j, Color.argb(alpha, r, g, b))
            }
        }
        appImage!!.setImageBitmap(bitmapEdit)
    }

    //method to decrease image RBG
    fun darkClicked(view: View?) {
        bitmapEdit = Bitmap.createBitmap(bitmapEdit2.width, bitmapEdit2.height, bitmapEdit2.config)

        for (i in 0 until bitmapEdit2.width) {
            for (j in 0 until bitmapEdit2.height) {
                val p = bitmapEdit2.getPixel(i, j)
                var r = Color.red(p)
                var g = Color.green(p)
                var b = Color.blue(p)
                var alpha = Color.alpha(p)
                r = r - 50
                g = g - 50
                b = b - 50
                alpha = alpha - 50
                bitmapEdit.setPixel(i, j, Color.argb(Color.alpha(p), r, g, b))
            }
        }
        appImage!!.setImageBitmap(bitmapEdit)
    }

    //Method to flip image
    fun flipClicked(view: View?) {
        appImage.setScaleY(-1f)
    }

    //method to scale up by 2
    fun bigSizeClicked(view: View?) {
        appImage.setScaleY(2f)
        appImage.setScaleX(2f)
    }

    //method to scale down by 2
    fun smallSizeClicked(view: View?) {
        appImage.setScaleY(.5f)
        appImage.setScaleX(.5f)
    }

    //method to set image to grayscale
    fun grayscaleClicked(view: View?) {
        bitmapEdit = Bitmap.createBitmap(bitmapEdit2.width, bitmapEdit2.height, bitmapEdit2.config)
        for (i in 0 until bitmapEdit2.width) {
            for (j in 0 until bitmapEdit2.height) {
                val p = bitmapEdit2.getPixel(i, j)
                var r = Color.red(p)
                var g = Color.green(p)
                var b = Color.blue(p)
                var alpha = Color.alpha(p)
                r = 70
                g = 70
                b = 70
                alpha = 0
                bitmapEdit.setPixel(i, j, Color.argb(Color.alpha(p), r, g, b))
            }
        }
        appImage!!.setImageBitmap(bitmapEdit)
    }

    //method to set image RBG to blue
    fun blueClicked(view: View?) {
        bitmapEdit = Bitmap.createBitmap(bitmapEdit2.width, bitmapEdit2.height, bitmapEdit2.config)
        for (i in 0 until bitmapEdit2.width) {
            for (j in 0 until bitmapEdit2.height) {
                val p = bitmapEdit2.getPixel(i, j)
                var r = Color.red(p)
                var g = Color.green(p)
                var b = Color.blue(p)
                var alpha = Color.alpha(p)
                r = 0
                g = 0
                b = b + 150
                alpha = 0
                bitmapEdit.setPixel(i, j, Color.argb(Color.alpha(p), r, g, b))
            }
        }
        appImage!!.setImageBitmap(bitmapEdit)
    }
}