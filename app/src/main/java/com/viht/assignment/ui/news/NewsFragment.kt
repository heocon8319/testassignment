package com.viht.assignment.ui.news

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.viht.assignment.databinding.FragmentNewsBinding
import com.viht.assignment.ui.base.adapter.RecyclerItem
import com.viht.assignment.ui.news.view.checkinout.CheckInOut
import com.viht.assignment.ui.news.view.event.Event
import com.viht.assignment.ui.news.view.header.Header
import com.viht.assignment.ui.news.view.portfoliodownload.PortfolioDownLoad
import com.viht.assignment.ui.news.view.portfolioimage.PortfolioImage
import com.viht.assignment.ui.newsdetail.DetailNewsActivity
import com.viht.assignment.util.Constants.INTENT_FRAGMENT_TYPE
import com.viht.assignment.util.launchActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment() {

    companion object {
        fun newInstance() = NewsFragment()
    }

    private val viewModel: NewsViewModel by viewModels()

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    private val listAdapter by lazy {
        NewsAdapter {
            handleClickItem(it)
        }
    }
    private var count = 0
    private var data: ArrayList<RecyclerItem> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    private fun initView() {
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }

        data = arrayListOf()
        getData()

        binding.scrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            // on scroll change we are checking when users scroll as bottom.
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                // in this method we are incrementing page number,
                // making progress bar visible and calling get data method.
                count++
                // on below line we are making our progress bar visible.
                binding.pbLoading.visibility = View.VISIBLE
                if (count < 10) {
                    // on below line we are again calling
                    // a method to load data in our array list.
                    getData()
                } else {
                    binding.pbLoading.visibility = View.GONE
                }
            }
        })
    }

    private fun initData() {
        viewModel.error.observe(viewLifecycleOwner) {
            binding.rvNews.visibility = View.VISIBLE
            binding.pbLoading.visibility = View.GONE
            Log.d("viht error", it)
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.response.observe(viewLifecycleOwner) {
            binding.rvNews.visibility = View.VISIBLE
            data.addAll(it)
            listAdapter.submitList(data)
            binding.rvNews.adapter = listAdapter
        }
    }

    private fun getData() {
        viewModel.loadNews()
    }

    private fun handleClickItem(item: RecyclerItem) {
        when (item) {
            is Header -> {
                //date
            }
            is CheckInOut -> {
                navigateToActivity(item.type)
            }
            is Event -> {
                if (item.clickAdd) {
                    Toast.makeText(context, "Add calendar", Toast.LENGTH_SHORT).show()
                } else {
                    navigateToActivity("event")
                }
            }
            is PortfolioDownLoad -> {
                if (item.clickDownload) {
                    Toast.makeText(context, "Download file", Toast.LENGTH_SHORT).show()
                } else {
                    navigateToActivity("portfolioDownload")
                }
            }
            is PortfolioImage -> {
                navigateToActivity("portfolioImage")
            }
        }
    }

    private fun navigateToActivity(type: String){
        context?.launchActivity<DetailNewsActivity> {
            putExtra(INTENT_FRAGMENT_TYPE, type)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}