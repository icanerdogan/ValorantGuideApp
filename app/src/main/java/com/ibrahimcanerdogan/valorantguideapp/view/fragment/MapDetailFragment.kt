package com.ibrahimcanerdogan.valorantguideapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ibrahimcanerdogan.valorantguideapp.R
import com.ibrahimcanerdogan.valorantguideapp.databinding.FragmentMapDetailBinding

private const val MAP_NAME = "MapNameParam"
private const val MAP_COORDINATE = "MapCoordinateParam"
private const val MAP_SPLASH_ICON_URL = "MapSplashIconParam"
private const val MAP_DISPLAY_ICON_URL = "MapDisplayIconParam"

class MapDetailFragment : Fragment() {

    private var _binding: FragmentMapDetailBinding? = null
    private val binding get() = _binding!!

    private var mapName: String? = null
    private var mapCoordinate: String? = null
    private var mapSplashIcon: String? = null
    private var mapDisplayIcon: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mapName = it.getString(MAP_NAME)
            mapCoordinate = it.getString(MAP_COORDINATE)
            mapSplashIcon = it.getString(MAP_SPLASH_ICON_URL)
            mapDisplayIcon = it.getString(MAP_DISPLAY_ICON_URL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapDetailBinding.inflate(inflater, container, false)
        Glide.with(binding.root.context)
            .load(mapSplashIcon)
            .into(binding.imageViewMapSplash)
        Glide.with(binding.root.context)
            .load(mapDisplayIcon)
            .into(binding.imageViewMap)
        binding.textViewMapName.text = mapName
        binding.textViewCoordinates.text = mapCoordinate
        binding.frameLayoutMapDetail.setOnClickListener {
            closeFragment()
        }
        return binding.root
    }

    private fun closeFragment() {
        binding.frameLayoutMapDetail.visibility = View.GONE
        onPause()
    }

    override fun onResume() {
        super.onResume()
        // Hide the bottom navigation bar
        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)?.visibility = View.GONE
    }

    override fun onPause() {
        super.onPause()
        // Show the bottom navigation bar
        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)?.visibility = View.VISIBLE
    }

    companion object {
        @JvmStatic
        fun newInstance(mapName: String, mapCoordinate: String, mapSplashIcon: String, mapDisplayIcon: String?) =
            MapDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(MAP_NAME, mapName)
                    putString(MAP_COORDINATE, mapCoordinate)
                    putString(MAP_SPLASH_ICON_URL, mapSplashIcon)
                    putString(MAP_DISPLAY_ICON_URL, mapDisplayIcon)
                }
            }
    }
}