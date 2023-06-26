package com.example.galleryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.galleryapp.Model.GalleryData


class FullScreenViewActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: FullScreenViewAdapter
    private var modelList: ArrayList<GalleryData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fullscreen_viewpager)

        viewPager = findViewById(R.id.viewPager)

        val currentPosition = intent.getIntExtra("current_position", 0)
        modelList = intent.getSerializableExtra("gallery_data") as ArrayList<GalleryData>

        viewPagerAdapter = FullScreenViewAdapter(this, modelList)
        viewPager.adapter = viewPagerAdapter
        viewPager.currentItem = currentPosition
    }
}