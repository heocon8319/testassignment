package com.viht.assignment.ui.newsdetail.view.checkinoutdetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.viht.assignment.R

class DetailCheckInOutFragment : Fragment() {

    companion object {
        fun newInstance() = DetailCheckInOutFragment()
    }

    private lateinit var viewModel: DetailCheckInOutViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_check_in_out, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailCheckInOutViewModel::class.java)
        // TODO: Use the ViewModel
    }

}