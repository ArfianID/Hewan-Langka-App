package com.horizon.hewanlangka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title = "Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvName: TextView = findViewById(R.id.tv_set_name)
        val tvSetImage: ImageView = findViewById(R.id.tv_set_image)
        val tvSetDetail: TextView = findViewById(R.id.tv_set_detail)
            
        val name = intent.getStringExtra(EXTRA_NAME)
        val image1 = intent.getIntExtra(EXTRA_PHOTO1, 0)
        val detail = intent.getStringExtra(EXTRA_DETAIL)

        tvName.text = name
        Glide.with(this)
            .load(image1)
            .into(tvSetImage)
        tvSetDetail.text = detail
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_ASAL = "extra_asal"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_PHOTO1 = "extra_photo1"
        const val EXTRA_DETAIL = "extra_detail"
    }
}