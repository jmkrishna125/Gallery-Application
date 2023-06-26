package com.example.galleryapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.galleryapp.Model.GalleryData


class FullScreenViewAdapter (private val context: Context, private val galleryModelList: ArrayList<GalleryData>) : PagerAdapter(){

    override fun getCount(): Int {
        return galleryModelList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_full_screen, container, false)
        val imageView = view.findViewById<ImageView>(R.id.full_image)
        val imageTitle = view.findViewById<TextView>(R.id.title)
        val imageDescription = view.findViewById<TextView>(R.id.description)

        val modelData = galleryModelList[position]
        Glide.with(context).load(modelData.imageUrl).into(imageView)
        imageTitle.text = modelData.title
        imageDescription.text = modelData.description

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
