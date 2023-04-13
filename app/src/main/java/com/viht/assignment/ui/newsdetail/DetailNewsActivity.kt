package com.viht.assignment.ui.newsdetail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.viht.assignment.R
import com.viht.assignment.util.Constants.INTENT_FRAGMENT_TYPE
import com.viht.assignment.util.replaceFragment

class DetailNewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)

        val type = intent.extras?.getString(INTENT_FRAGMENT_TYPE, "event")
        Log.d("viht", type.toString())
        if (savedInstanceState == null) {
            replaceFragment(DetailNewsFragment.newInstance(), R.id.container)
        }
    }
}