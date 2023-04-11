package com.viht.assignment.ui.portfolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.viht.assignment.databinding.FragmentPortfolioBinding

class PortfolioFragment : Fragment() {

    companion object {
        fun newInstance() = PortfolioFragment()
    }

    private lateinit var viewModel: PortfolioViewModel
    private var _binding: FragmentPortfolioBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[PortfolioViewModel::class.java]

        _binding = FragmentPortfolioBinding.inflate(inflater, container, false)

        viewModel.text.observe(viewLifecycleOwner) {
            binding.tvHello.text = it
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}