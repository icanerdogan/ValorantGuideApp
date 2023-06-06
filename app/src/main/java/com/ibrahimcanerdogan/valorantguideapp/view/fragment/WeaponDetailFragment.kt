package com.ibrahimcanerdogan.valorantguideapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ibrahimcanerdogan.valorantguideapp.R
import com.ibrahimcanerdogan.valorantguideapp.databinding.FragmentWeaponDetailBinding
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import com.ibrahimcanerdogan.valorantguideapp.view.adapter.weapon.WeaponAdapter
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.weapon.WeaponViewModel
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.weapon.WeaponViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

private const val ARG_WEAPON_UUID = "weaponUUID"

@AndroidEntryPoint
class WeaponDetailFragment : Fragment() {

    private var _binding: FragmentWeaponDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(this, factory).get(WeaponViewModel::class.java)
    }

    @Inject
    lateinit var factory: WeaponViewModelFactory

    private var weaponUUID: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            weaponUUID = it.getString(ARG_WEAPON_UUID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeaponDetailBinding.inflate(inflater, container, false)
        setWeaponDetailData()
        binding.frameLayoutWeaponDetail.setOnClickListener {
            closeFragment()
        }
        return binding.root
    }

    private fun setWeaponDetailData() {
        viewModel.getDetailWeaponData(weaponUUID!!)
        viewModel.weaponData.observe(viewLifecycleOwner) {response ->
            when(response) {
                is Resource.Success -> {
                    setProgressBar(false)
                    response.data.let { weaponData ->
                        binding.apply {
                            textViewWeaponDetailName.text = weaponData?.weaponDisplayName
                        }
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
    private fun closeFragment() {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayoutWeapon, WeaponFragment()).commit()
    }

    private fun setProgressBar(isShown : Boolean) {
        binding.progressIndicator.visibility = if (isShown) View.VISIBLE else View.GONE
    }

    override fun onResume() {
        super.onResume()
        // Hide the bottom navigation bar
        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)?.visibility = View.GONE
    }

    companion object {
        @JvmStatic
        fun newInstance(weaponUUID: String) =
            WeaponDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_WEAPON_UUID, weaponUUID)
                }
            }
    }
}