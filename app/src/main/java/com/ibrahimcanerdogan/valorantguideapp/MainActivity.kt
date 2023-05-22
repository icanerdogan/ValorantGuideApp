package com.ibrahimcanerdogan.valorantguideapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ibrahimcanerdogan.valorantguideapp.databinding.ActivityMainBinding
import com.ibrahimcanerdogan.valorantguideapp.view.fragment.AgentFragment
import com.ibrahimcanerdogan.valorantguideapp.view.fragment.MapsFragment
import com.ibrahimcanerdogan.valorantguideapp.view.fragment.OtherFragment
import com.ibrahimcanerdogan.valorantguideapp.view.fragment.WeaponFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(AgentFragment())

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