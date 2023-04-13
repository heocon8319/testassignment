package com.viht.assignment.ui.newsdetail.view.filedetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.viht.assignment.R

class DetailFileFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFileFragment()
    }

    private lateinit var viewModel: DetailFileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_file, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailFileViewModel::class.java)
        // TODO: Use the ViewModel
    }

}