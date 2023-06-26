package com.example.galleryapp


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.example.galleryapp.Model.GalleryData
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException


class GalleryFragment : Fragment() {

    private lateinit var gridView: GridView
    private val imageUrls: ArrayList<String> = ArrayList()
    private val galleryData: ArrayList<GalleryData> = ArrayList()
    private lateinit var adapter: GalleryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_main, container, false)
        gridView = view.findViewById(R.id.gridview)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupGridView()
        setupGridViewClickListener()
    }

    private fun setupGridView() {
        loadGalleryDataFromJson()

        adapter = GalleryAdapter(requireContext(), imageUrls)
        gridView.adapter = adapter
    }

    private fun setupGridViewClickListener() {
        gridView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(requireContext(), FullScreenViewActivity::class.java)
            intent.putExtra("current_position", position)
            intent.putExtra("gallery_data", galleryData)
            startActivity(intent)
        }
    }



    private fun loadGalleryDataFromJson() {
        val json = loadJSONFromAsset()

        try {
            val jsonArray = JSONArray(json)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val imageUrl = jsonObject.getString("url")
                val galleryModel = GalleryData(
                    jsonObject.getString("title"),
                    jsonObject.getString("explanation"),
                    imageUrl
                )
                imageUrls.add(imageUrl)
                galleryData.add(galleryModel)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun loadJSONFromAsset(): String {
        val jsonString: String
        try {
            val inputStream = requireActivity().assets.open("nasa_details.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            jsonString = String(buffer, Charsets.UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return jsonString
    }
}