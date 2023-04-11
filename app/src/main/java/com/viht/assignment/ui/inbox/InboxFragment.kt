package com.viht.assignment.ui.inbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.viht.assignment.databinding.FragmentInboxBinding

class InboxFragment : Fragment() {

    companion object {
        fun newInstance() = InboxFragment()
    }

    private lateinit var viewModel: InboxViewModel
    private var _binding: FragmentInboxBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[InboxViewModel::class.java]

        _binding = FragmentInboxBinding.inflate(inflater, container, false)

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