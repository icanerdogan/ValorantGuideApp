package com.ibrahimcanerdogan.valorantguideapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.ibrahimcanerdogan.valorantguideapp.R
import com.ibrahimcanerdogan.valorantguideapp.databinding.ActivityMainBinding
import com.ibrahimcanerdogan.valorantguideapp.view.fragment.AgentFragment
import com.ibrahimcanerdogan.valorantguideapp.view.fragment.MapsFragment
import com.ibrahimcanerdogan.valorantguideapp.view.fragment.other.OtherFragment
import com.ibrahimcanerdogan.valorantguideapp.view.fragment.WeaponFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(AgentFragment())
        binding.bottomNavigationView.menu.getItem(1).isChecked = true
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.navigation_agent -> replaceFragment(AgentFragment())
                R.id.navigation_maps -> replaceFragment(MapsFragment())
                R.id.navigation_weapon -> replaceFragment(WeaponFragment())
                R.id.navigation_other -> replaceFragment(OtherFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit()
    }
}