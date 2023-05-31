package com.ibrahimcanerdogan.valorantguideapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.ibrahimcanerdogan.valorantguideapp.R
import com.ibrahimcanerdogan.valorantguideapp.databinding.FragmentMapDetailBinding
import com.ibrahimcanerdogan.valorantguideapp.databinding.FragmentMapsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val MAP_NAME = "param1"
private const val MAP_COORDINATE = "param2"
private const val MAP_SPLASH_ICON_URL = "param1"
private const val MAP_DISPLAY_ICON_URL = "param2"
/**
 * A simple [Fragment] subclass.
 * Use the [MapDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MapDetailFragment : Fragment() {

    private var _binding: FragmentMapDetailBinding? = null
    private val binding get() = _binding!!

    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    private var param4: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(MAP_NAME)
            param2 = it.getString(MAP_COORDINATE)
            param3 = it.getString(MAP_SPLASH_ICON_URL)
            param4 = it.getString(MAP_DISPLAY_ICON_URL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapDetailBinding.inflate(inflater, container, false)
        Glide.with(binding.root.context)
            .load(MAP_SPLASH_ICON_URL)
            .into(binding.imageViewMapSplash)
        Glide.with(binding.root.context)
            .load(MAP_DISPLAY_ICON_URL)
            .into(binding.imageViewMap)
        binding.textViewMapName.text = MAP_NAME
        binding.textViewCoordinates.text = MAP_COORDINATE
        binding.frameLayoutMapDetail.setOnClickListener {
            closeFragment()
        }
        return binding.root
    }

    private fun closeFragment() {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .remove(this)
            .commit()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MapDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String, param3: String, param4: String?) =
            MapDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(MAP_NAME, param1)
                    putString(MAP_COORDINATE, param2)
                    putString(MAP_SPLASH_ICON_URL, param3)
                    putString(MAP_DISPLAY_ICON_URL, param4)
                }
            }
    }
}