package com.viht.assignment.ui.newsdetail

import android.os.Bundle
import android.view.LayoutInflater
import com.viht.assignment.R
import com.viht.assignment.databinding.ActivityDetailNewsBinding
import com.viht.assignment.ui.base.BaseActivity
import com.viht.assignment.ui.newsdetail.view.checkinoutdetail.DetailCheckInOutFragment
import com.viht.assignment.ui.newsdetail.view.eventdetail.DetailEventFragment
import com.viht.assignment.ui.newsdetail.view.filedetail.DetailFileFragment
import com.viht.assignment.ui.newsdetail.view.imagedetail.DetailImageFragment
import com.viht.assignment.util.Constants.INTENT_FRAGMENT_TYPE
import com.viht.assignment.util.replaceFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailNewsActivity : BaseActivity<ActivityDetailNewsBinding>() {

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        ActivityDetailNewsBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //hide actionbar
        supportActionBar?.hide()

        initView()
        handleBackButton()
    }

    private fun initView() {

        var title = getString(R.string.news_detail_act_title_event)
        val frag = when (intent.extras?.getString(INTENT_FRAGMENT_TYPE, "event")) {
            "checkIn" -> {
                title = getString(R.string.news_detail_act_title_check_in)
                DetailCheckInOutFragment.newInstance()
            }
            "checkOut" -> {
                title = getString(R.string.news_detail_act_title_check_out)
                DetailCheckInOutFragment.newInstance()
            }
            "event" -> {
                title = getString(R.string.news_detail_act_title_event)
                DetailEventFragment.newInstance()
            }
            "portfolioDownload" -> {
                title = getString(R.string.news_detail_act_title_download)
                DetailFileFragment.newInstance()
            }
            "portfolioImage" -> {
                title = getString(R.string.news_detail_act_title_image)
                DetailImageFragment.newInstance()
            }
            else -> DetailEventFragment.newInstance()
        }
        binding.tvTitle.text = title
        replaceFragment(frag, R.id.container)
    }

    private fun handleBackButton() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

}