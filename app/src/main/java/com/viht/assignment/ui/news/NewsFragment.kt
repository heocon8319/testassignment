package com.viht.assignment.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.viht.assignment.databinding.FragmentNewsBinding
import com.viht.assignment.ui.base.adapter.AdapterClick
import com.viht.assignment.ui.base.adapter.AdapterListener
import com.viht.assignment.ui.base.adapter.RecyclerItem
import com.viht.assignment.ui.news.view.checkinout.CheckInOut
import com.viht.assignment.ui.news.view.event.Event
import com.viht.assignment.ui.news.view.header.Header
import com.viht.assignment.ui.news.view.portfoliodownload.PortfolioDownLoad
import com.viht.assignment.ui.news.view.portfolioimage.PortfolioImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment(), AdapterListener {

    companion object {
        fun newInstance() = NewsFragment()
    }

    private val viewModel: NewsViewModel by viewModels()

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    private val listAdapter by lazy { NewsAdapter(this) }
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

        initialize()
    }

    private fun initialize() {

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
                if (count < 20) {
                    // on below line we are again calling
                    // a method to load data in our array list.
                    getData()
                }
            }
        })
    }

    private fun getData() {
        binding.rvNews.visibility = View.VISIBLE
        data.addAll(ExampleData.createList())
        listAdapter.submitList(data)
        binding.rvNews.adapter = listAdapter
    }

    override fun listen(click: AdapterClick?) {
        when (click) {
            is Header -> {
                //date
            }
            is CheckInOut -> {
                Toast.makeText(context, "show detail check in out", Toast.LENGTH_SHORT).show()
            }
            is Event -> {
                Toast.makeText(context, "show detail event", Toast.LENGTH_SHORT).show()
            }
            is PortfolioDownLoad -> {
                Toast.makeText(context, "show download", Toast.LENGTH_SHORT).show()
            }
            is PortfolioImage -> {
                Toast.makeText(context, "show image", Toast.LENGTH_SHORT).show()
            }
        }
    }

//    private fun initView() {
//        viewModel.text.observe(viewLifecycleOwner) {
//            binding.tvHello.text = it
//        }
//    }

////    private var adapterNews = NewsAdapter {
////        onClickNews(it)
////    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
////        initView()
////        initData()
//    }
//
////    private fun initView() {
////        val layoutManager = LinearLayoutManager(context)
////        binding.rvNews.layoutManager = layoutManager
////
////        val dividerItemDecoration = DividerItemDecoration(
////            binding.rvNews.context,
////            layoutManager.orientation
////        )
////        binding.rvNews.addItemDecoration(dividerItemDecoration)
////
////        binding.rvNews.adapter = adapterNews
////    }
////
////    private fun initData() {
////        viewModel.error.observe(this) {
////            Log.d("viht error", it)
////            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
////            adapterNews.submitList(mutableListOf())
////        }
////
////        viewModel.loading.observe(this) {
////            if (it) {
////                Toast.makeText(context, "showProgressBar", Toast.LENGTH_SHORT).show()
////                //showProgressBar()
////            } else {
////                Toast.makeText(context, "hideProgressBar", Toast.LENGTH_SHORT).show()
////                //hideProgressBar()
////            }
////        }
////
////        viewModel.response.observe(this) {
////            Log.d("viht", it.toString())
////            adapterNews.submitList(it?.toConvertedData())
////        }
////    }
////
////    private fun onClickNews(news: News) {
////        Toast.makeText(context, news.eventDescription, Toast.LENGTH_SHORT).show()
////    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}