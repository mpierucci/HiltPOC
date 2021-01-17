package com.mpierucci.hiltpoc.btc.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.mpierucci.android.hiltpoc.btc.domain.Charter
import com.mpierucci.hiltpoc.btc.presentation.databinding.FragmentBtcBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BtcFragment : Fragment() {

    private val viewModel by viewModels<BtcViewModel>()
    private var resultJob: Job? = null
    private var _binding: FragmentBtcBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBtcBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStart() {
        super.onStart()
        resultJob = lifecycleScope.launch {
            viewModel.charters.collect { charterResult ->
                when {
                    charterResult.isSuccess -> handleSuccess(charterResult.getOrNull()!!)
                    charterResult.isFailure -> handleFailure(charterResult.exceptionOrNull()!!)
                }
            }
        }
    }

    override fun onStop() {
        resultJob?.cancel()
        super.onStop()
    }

    private fun handleSuccess(charter: Charter) {
        binding.name.text = charter.name
        binding.disclaimer.text = charter.disclaimer
        val bpiText = charter.bpis.joinToString("") {
            "${it.code}: ${it.rate}\n"
        }
        binding.bpi.text = bpiText
    }

    private fun handleFailure(throwable: Throwable) {
        Toast.makeText(requireContext(), throwable.message, Toast.LENGTH_SHORT).show()
    }
}