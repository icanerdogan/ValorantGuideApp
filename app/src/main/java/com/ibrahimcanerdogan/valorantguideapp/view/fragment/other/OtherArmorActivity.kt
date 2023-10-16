
package com.ibrahimcanerdogan.valorantguideapp.view.fragment.other

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibrahimcanerdogan.valorantguideapp.databinding.ActivityOtherArmorBinding
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import com.ibrahimcanerdogan.valorantguideapp.view.adapter.other.armor.ArmorAdapter
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.other.armor.ArmorViewModel
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.other.armor.ArmorViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OtherArmorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOtherArmorBinding

    @Inject
    lateinit var factory: ArmorViewModelFactory
    @Inject
    lateinit var armorAdapter: ArmorAdapter

    private val viewModel by lazy {
        ViewModelProvider(this, factory).get(ArmorViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtherArmorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.recyclerViewOtherArmor.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = armorAdapter
        }

        setArmorData()
    }

    private fun setArmorData() {
        viewModel.getAllArmorData()
        viewModel.armorData.observe(this) { response ->
            when(response) {
                is Resource.Success -> {
                    setProgressBar(false)
                    response.data.let { listMapData ->
                        armorAdapter.setData(listMapData!!)
                    }
                }
                is Resource.Error -> {
                    setProgressBar(false)
                    response.message?.let { errorMessage ->
                        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}