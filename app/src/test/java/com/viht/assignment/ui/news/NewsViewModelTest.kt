package com.viht.assignment.ui.news

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.viht.assignment.data.remote.api.ApiResult
import com.viht.assignment.data.remote.response.DataResponse
import com.viht.assignment.data.remote.response.NewsResponse
import com.viht.assignment.repository.NewsRepository
import com.viht.assignment.ui.base.adapter.RecyclerItem
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.rules.TestRule

@OptIn(ExperimentalCoroutinesApi::class)
internal class NewsViewModelTest {
    private val newsRepo: NewsRepository = mockk()
    private lateinit var viewModel: NewsViewModel

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private val dispatcher: TestDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = NewsViewModel(newsRepo)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `should emit loading`() {
        coEvery {
            newsRepo.getNews()
        }

        viewModel.loadNews()

        coVerify {
            newsRepo.getNews()
        }
        Assert.assertEquals(viewModel.loading.value, true)
    }

    @Test
    fun `should emit empty list when api response success`() {
        val response =
            ApiResult.Success(DataResponse(data = NewsResponse(userTimeline = arrayListOf())))
        val listRecycleView: ArrayList<RecyclerItem> = arrayListOf()

        coEvery {
            newsRepo.getNews()
        } answers {
            flowOf(response)
        }

        viewModel.loadNews()

        coVerify {
            newsRepo.getNews()
        }
        Assert.assertEquals(viewModel.response.value, listRecycleView)
    }


    @Test
    fun `should emit list when api response success`() {
        val response =
            ApiResult.Success(DataResponse(data = NewsResponse(userTimeline = arrayListOf())))
        val listRecycleView: ArrayList<RecyclerItem> = arrayListOf()

        coEvery {
            newsRepo.getNews()
        } answers {
            flowOf(response)
        }

        viewModel.loadNews()

        coVerify {
            newsRepo.getNews()
        }
        Assert.assertEquals(viewModel.response.value, listRecycleView)
    }

    @Test
    fun `should emit error object when api response error`() {
        val message = "No internet connection"

        coEvery {
            newsRepo.getNews()
        } answers {
            flow {
                emit(ApiResult.Error(message))
            }
        }

        viewModel.loadNews()

        coVerify {
            newsRepo.getNews()
        }

        Assert.assertEquals(viewModel.error.value, message)
    }
}