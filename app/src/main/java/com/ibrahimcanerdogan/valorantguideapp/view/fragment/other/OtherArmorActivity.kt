
package com.ibrahimcanerdogan.valorantguideapp.view.fragment.other

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.ibrahimcanerdogan.valorantguideapp.R
import com.ibrahimcanerdogan.valorantguideapp.databinding.ActivityOtherArmorBinding

class OtherArmorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOtherArmorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtherArmorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}