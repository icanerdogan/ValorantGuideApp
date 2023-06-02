package com.ibrahimcanerdogan.valorantguideapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.ibrahimcanerdogan.valorantguideapp.databinding.FragmentAgentBinding
import com.ibrahimcanerdogan.valorantguideapp.util.Resource
import com.ibrahimcanerdogan.valorantguideapp.view.adapter.agent.AgentAdapter
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.agent.AgentViewModel
import com.ibrahimcanerdogan.valorantguideapp.view.viewmodel.agent.AgentViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AgentFragment : Fragment() {
    private var _binding: FragmentAgentBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(this, factory).get(AgentViewModel::class.java)
    }
    @Inject
    lateinit var factory: AgentViewModelFactory
    @Inject
    lateinit var agentAdapter: AgentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAgentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPagerAgent.apply {
            adapter = agentAdapter
        }
        setAgentData()
    }

    private fun setAgentData() {
        viewModel.getAllAgentData()
        viewModel.agentData.observe(viewLifecycleOwner) { response ->
            when(response) {
                is Resource.Success -> {
                    setProgressBar(false)
                    response.data.let { listAgentData ->
                        agentAdapter.setData(listAgentData!!)
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
        binding.progressBar.visibility = if (isShown) View.VISIBLE else View.GONE
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}