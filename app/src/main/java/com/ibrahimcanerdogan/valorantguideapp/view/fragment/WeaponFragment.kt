package com.ibrahimcanerdogan.valorantguideapp.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibrahimcanerdogan.valorantguideapp.databinding.FragmentWeaponBinding
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import com.ibrahimcanerdogan.valorantguideapp.view.adapter.weapon.WeaponAdapter
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.weapon.WeaponViewModel
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.weapon.WeaponViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WeaponFragment : Fragment() {

    private var _binding: FragmentWeaponBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(this, factory).get(WeaponViewModel::class.java)
    }

    @Inject
    lateinit var factory: WeaponViewModelFactory
    @Inject
    lateinit var weaponAdapter: WeaponAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeaponBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewWeapon.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = weaponAdapter
        }
        setWeaponData()
    }

    private fun setWeaponData() {
        viewModel.getAllWeaponData()
        viewModel.weaponData.observe(viewLifecycleOwner) { response ->
            when(response) {
                is Resource.Success -> {
                    setProgressBar(false)
                    response.data.let { listWeaponData ->
                        listWeaponData?.let {
                            weaponAdapter.setData(it)
                            Log.i("Weapon Success Data", it.toString())
                        }

                    }
                }
                is Resource.Error -> {
                    setProgressBar(false)
                    response.message?.let { errorMessage ->
                        Toast.makeText(activity, errorMessage, Toast.LENGTH_LONG).show()
                        Log.e("Weapon Error Data", errorMessage)
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
}
