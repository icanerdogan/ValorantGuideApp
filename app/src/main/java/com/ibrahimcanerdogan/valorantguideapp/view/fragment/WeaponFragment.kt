package com.ibrahimcanerdogan.valorantguideapp.view.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.WeaponData
import com.ibrahimcanerdogan.valorantguideapp.databinding.FragmentWeaponBinding
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import com.ibrahimcanerdogan.valorantguideapp.view.adapter.weapon.WeaponAdapter
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.weapon.WeaponViewModel
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.weapon.WeaponViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import net.cachapa.expandablelayout.ExpandableLayout
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
        binding.apply {
            // Heavy Weapon
            setWeaponDataUI("Heavy", linearLayoutHeavyTitle, recyclerViewHeavy, expandableLayoutHeavy)
            // Rifle Weapon
            setWeaponDataUI("Rifle", linearLayoutRifleTitle, recyclerViewRifle, expandableLayoutRifle)
            // Sniper Weapon
            setWeaponDataUI("Sniper", linearLayoutSniperTitle, recyclerViewSniper, expandableLayoutSniper)
            // Shotgun Weapon
            setWeaponDataUI("Shotgun", linearLayoutShotgunTitle, recyclerViewShotgun, expandableLayoutShotgun)
            // SMG Weapon
            setWeaponDataUI("SMG", linearLayoutSMGTitle, recyclerViewSMG, expandableLayoutSMG)
            // SideArm Weapon
            setWeaponDataUI("Sidearm", linearLayoutSidearmTitle, recyclerViewSidearm, expandableLayoutSidearm)
            // Melee Weapon
            setWeaponDataUI("Melee", linearLayoutMeleeTitle, recyclerViewMelee, expandableLayoutMelee)
        }
    }

    private fun setWeaponDataUI(
        weaponCategory: String,
        linearLayoutTitle: LinearLayout,
        recyclerView: RecyclerView,
        expandableLayout: ExpandableLayout
    ) {
        expandableLayout.setInterpolator(LinearInterpolator())

        linearLayoutTitle.setOnClickListener {
            viewModel.getAllWeaponData(weaponCategory)
            viewModel.weaponData.observe(viewLifecycleOwner, ::setLiveData)
            Handler(Looper.getMainLooper()).postDelayed({
                if (!expandableLayout.isExpanded) {
                    closeAllExpandableLayout()
                    expandableLayout.isExpanded = true
                } else {
                    expandableLayout.isExpanded = false
                    weaponAdapter.setData(listOf())
                }
            }, 200)
        }
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = weaponAdapter
        }
    }
    private fun setLiveData(response: Resource<List<WeaponData>>) {
        when (response) {
            is Resource.Success -> {
                setProgressBar(false)
                response.data.let { listWeaponData ->
                    listWeaponData?.let {
                        weaponAdapter.setData(it)
                        //Log.i("Weapon Success Data", it.toString())
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

    private fun closeAllExpandableLayout() {
        binding.apply {
            expandableLayoutHeavy.isExpanded = false
            expandableLayoutRifle.isExpanded = false
            expandableLayoutSniper.isExpanded = false
            expandableLayoutShotgun.isExpanded = false
            expandableLayoutSMG.isExpanded = false
            expandableLayoutSidearm.isExpanded = false
            expandableLayoutMelee.isExpanded = false
        }
    }
    private fun setProgressBar(isShown : Boolean) {
        binding.progressIndicator.visibility = if (isShown) View.VISIBLE else View.GONE
    }
}
