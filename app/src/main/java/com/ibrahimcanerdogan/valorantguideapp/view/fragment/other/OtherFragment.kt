package com.ibrahimcanerdogan.valorantguideapp.view.fragment.other

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ibrahimcanerdogan.valorantguideapp.databinding.FragmentOtherBinding


class OtherFragment : Fragment() {

    private var _binding: FragmentOtherBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtherBinding.inflate(inflater, container, false)

        binding.apply {
            llArmor.setOnClickListener {
                val intent = Intent(activity, OtherArmorActivity::class.java)
                startActivity(intent)
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        private val TAG = "OtherFragment"
    }
}