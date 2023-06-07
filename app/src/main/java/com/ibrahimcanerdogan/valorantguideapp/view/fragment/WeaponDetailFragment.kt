package com.ibrahimcanerdogan.valorantguideapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ibrahimcanerdogan.valorantguideapp.R
import com.ibrahimcanerdogan.valorantguideapp.data.model.weapon.WeaponData
import com.ibrahimcanerdogan.valorantguideapp.databinding.FragmentWeaponDetailBinding
import com.ibrahimcanerdogan.valorantguideapp.util.AnimationUtil
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
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
                        setWeaponDetailDataUI(weaponData)
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

    private fun setWeaponDetailDataUI(weaponData: WeaponData?) {
        binding.apply {
            Glide.with(binding.root.context)
                .load(weaponData?.weaponDisplayIcon)
                .into(binding.imageViewWeaponDetailIcon)

            textViewWeaponDetailName.text = weaponData?.weaponDisplayName

            if (weaponData?.weaponDisplayName != "Melee") {
                // STAT
                includeWeaponDetailStat.apply {
                    // Expandable Layout
                    llWeaponDetailStats.setOnClickListener {
                        AnimationUtil.animateArrow(imageViewArrowWeaponDetailStat)
                        expandableLayoutWeaponStats.isExpanded = !expandableLayoutWeaponStats.isExpanded
                    }
                    weaponData?.weaponStats?.let {
                        textViewWeaponDetailStatFireRate.text = getString(R.string.fire_rate, it.statFireRate.toString())
                        textViewWeaponDetailStatMagazineSize.text = getString(R.string.magazine_size, it.statMagazineSize.toString())
                        textViewWeaponDetailStatRunSpeed.text = getString(R.string.run_speed, it.statRunSpeedMultiplier.toString())
                        textViewWeaponDetailStatReloadSecond.text = getString(R.string.reload_second, it.statReloadTimeSeconds.toString())
                        textViewWeaponDetailStatFirstBulletAcc.text = getString(R.string.first_bullet_accuracy, it.statFirstBulletAccuracy.toString())
                        textViewWeaponDetailStatEquipTime.text = getString(R.string.equip_time, it.statEquipTimeSeconds.toString())
                        textViewWeaponDetailStatShotgunPelletCount.text = getString(R.string.shotgun_pellet_count, it.statShotgunPelletCount.toString())
                        textViewWeaponDetailStatWallPenetration.text = getString(R.string.wall_penetration, it.statWallPenetration.split("::")[1])
                    }
                }
                // DAMAGE
                includeWeaponDetailDamage.apply {
                    // Expandable Layout
                    llWeaponDetailDamage.setOnClickListener {
                        AnimationUtil.animateArrow(imageViewArrowWeaponDamage)
                        expandableLayoutWeaponDamage.isExpanded = !expandableLayoutWeaponDamage.isExpanded
                    }
                    weaponData?.weaponStats?.let {
                        if (it.statDamageRanges[0] != null) {
                            textViewWeaponDetailDamageFirstHead.text = it.statDamageRanges[0]!!.damageHead.toInt().toString()
                            textViewWeaponDetailDamageFirstBody.text = it.statDamageRanges[0]!!.damageBody.toString()
                            textViewWeaponDetailDamageFirstLeg.text = it.statDamageRanges[0]!!.damageLeg.toInt().toString()
                        }
                        if (it.statDamageRanges.size > 1) {
                            linearLayoutWeaponDamageSecond.visibility = View.VISIBLE
                            textViewWeaponDetailDamageSecondHead.text = it.statDamageRanges[1]!!.damageHead.toInt().toString()
                            textViewWeaponDetailDamageSecondBody.text = it.statDamageRanges[1]!!.damageBody.toString()
                            textViewWeaponDetailDamageSecondLeg.text = it.statDamageRanges[1]!!.damageLeg.toInt().toString()
                        }
                    }
                }
                // SHOP
                includeWeaponDetailShop.apply {
                    // Expandable Layout
                    llWeaponDetailShopData.setOnClickListener {
                        AnimationUtil.animateArrow(imageViewArrowWeaponShop)
                        expandableLayoutWeaponShopData.isExpanded = !expandableLayoutWeaponShopData.isExpanded
                    }
                    weaponData?.let {
                        textViewWeaponDetailShopCost.text = getString(R.string.shop_cost, it.weaponShop?.shopCost.toString())
                        textViewWeaponDetailShopCategory.text = getString(R.string.shop_category, it.weaponShop?.shopCategory)
                        if (!it.weaponShop?.shopImage.isNullOrEmpty()) {
                            Glide.with(binding.root.context)
                                .load(it.weaponShop?.shopImage)
                                .into(imageViewWeaponDetailShopIcon)
                        } else if (!it.weaponShop?.shopNewImage.isNullOrEmpty()) {
                            Glide.with(binding.root.context)
                                .load(it.weaponShop?.shopNewImage)
                                .into(imageViewWeaponDetailShopIcon)
                        } else if (!it.weaponShop?.shopNewImage2.isNullOrEmpty()) {
                            Glide.with(binding.root.context)
                                .load(it.weaponShop?.shopNewImage2)
                                .into(imageViewWeaponDetailShopIcon)
                        } else {
                            imageViewWeaponDetailShopIcon.visibility = View.GONE
                        }
                    }
                }
            } else {
                includeWeaponDetailStat.root.visibility = View.GONE
                includeWeaponDetailDamage.root.visibility = View.GONE
                includeWeaponDetailShop.root.visibility = View.GONE
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