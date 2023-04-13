package com.viht.assignment.ui.newsdetail.view.imagedetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.viht.assignment.R

class DetailImageFragment : Fragment() {

    companion object {
        fun newInstance() = DetailImageFragment()
    }

    private lateinit var viewModel: DetailImageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_image, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailImageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}