package com.example.galleryapp

import com.example.galleryapp.Model.GalleryData
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class DataClassTest {
    @Test
    fun testGalleryData() {

        val galleryData = GalleryData("Title", "Description", "Image_url")
        assertEquals("Title", galleryData.title)
        assertEquals("Description", galleryData.description)
        assertEquals("Image_url", galleryData.imageUrl)
    }
}