package com.ibrahimcanerdogan.valorantguideapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ibrahimcanerdogan.valorantguideapp.R
import com.ibrahimcanerdogan.valorantguideapp.databinding.FragmentMapsBinding
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import com.ibrahimcanerdogan.valorantguideapp.view.adapter.map.MapAdapter
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.map.MapViewModel
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.map.MapViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MapsFragment : Fragment() {

    private var _binding: FragmentMapsBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(this, factory).get(MapViewModel::class.java)
    }

    @Inject
    lateinit var factory: MapViewModelFactory
    @Inject
    lateinit var mapAdapter: MapAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewMap.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = mapAdapter
        }

        mapAdapter.onMapItemClick = { mapData ->
            val fragment = MapDetailFragment.newInstance(
                mapName = mapData.mapDisplayName,
                mapCoordinate = mapData.mapCoordinates,
                mapSplashIcon = mapData.mapSplashIcon,
                mapDisplayIcon = mapData.mapDisplayIcon
            )
            val fragmentManager = childFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            fragmentTransaction.replace(R.id.frameLayoutMaps, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        setMapData()
    }

    private fun setMapData() {
        viewModel.getAllMapData()
        viewModel.mapData.observe(viewLifecycleOwner) { response ->
            when(response) {
                is Resource.Success -> {
                    setProgressBar(false)
                    response.data.let { listMapData ->
                        mapAdapter.setData(listMapData!!)
                    }
                }
                is Resource.Error -> {
                    setProgressBar(false)
                    response.message?.let { errorMessage ->
                        Toast.makeText(activity, errorMessage, Toast.LENGTH_LONG).show()
                        println("An error occurred : $errorMessage")
                    }
                }
                is Resource.Loading -> {
                    setProgressBar(true)
                }
            }
        }
    }

    private fun setProgressBar(isShown : Boolean) {
        binding.progressIndicator.visibility = if (isShown) View.VISIBLE else View.GONE
    }

    override fun onResume() {
        super.onResume()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)?.visibility = View.VISIBLE
    }

}