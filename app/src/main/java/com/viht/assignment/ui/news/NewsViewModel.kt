package com.viht.assignment.ui.news

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.viht.assignment.data.remote.api.ApiResult
import com.viht.assignment.data.remote.response.DataResponse
import com.viht.assignment.data.remote.response.toConvertedData
import com.viht.assignment.model.NewsModel
import com.viht.assignment.model.toNewsModel
import com.viht.assignment.model.toRecycleItem
import com.viht.assignment.repository.NewsRepository
import com.viht.assignment.ui.base.BaseViewModel
import com.viht.assignment.ui.base.adapter.RecyclerItem
import com.viht.assignment.ui.news.view.header.Header
import com.viht.assignment.util.DateUtils
import com.viht.assignment.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repo: NewsRepository) : BaseViewModel() {

    private val _response: SingleLiveEvent<ArrayList<RecyclerItem>> = SingleLiveEvent()
    val response: LiveData<ArrayList<RecyclerItem>> get() = _response

    // getting news list using repository and passing it into live data
    fun loadNews() {
        showLoading(true)
        viewModelScope.launch {
            repo.getNews().collect { values ->
                when (values) {
                    is ApiResult.Success -> {
                        val list = handleDataResponse(values.data)
                        _response.postValue(list)
                        showLoading(false)
                    }
                    is ApiResult.Error -> {
                        handleError(values.message ?: "")
                        showLoading(false)
                    }
                    is ApiResult.Loading -> {
                        showLoading(true)
                    }
                }
            }
        }
    }

    private fun handleDataResponse(data: DataResponse?): ArrayList<RecyclerItem> {
        //list news from server have json
        val listNewsOriginal = data?.data?.toConvertedData()
        //list news from server no json
        val listNews: MutableList<NewsModel> = mutableListOf()
        listNewsOriginal?.forEach { response ->
            listNews.add(response.toNewsModel())
        }
        return convertToListRecycleItem(listNews)
    }

    private fun convertToListRecycleItem(listNews: MutableList<NewsModel>): ArrayList<RecyclerItem> {
        //group by event date
        val groupedMap: Map<String, List<NewsModel>> = listNews.groupBy {
            DateUtils.formatDateFromDateString(
                DateUtils.DATE_FORMAT_4,
                DateUtils.DATE_FORMAT_2, it.eventDate
            ) ?: ""
        }
        // convert to list recycle items
        val listRecycleItem: ArrayList<RecyclerItem> = arrayListOf()
        for (date: String in groupedMap.keys) {
            listRecycleItem.add(
                Header(
                    id = System.currentTimeMillis().toString(),
                    date = date
                )
            )
            val groupItems: List<NewsModel>? = groupedMap[date]
            groupItems?.forEach { response ->
                listRecycleItem.add(response.toRecycleItem())
            }
        }
        Log.d("viht", listRecycleItem.toString())
        return listRecycleItem
    }
}