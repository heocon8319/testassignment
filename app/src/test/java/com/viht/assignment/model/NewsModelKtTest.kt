package com.viht.assignment.model

import com.viht.assignment.ui.base.adapter.RecyclerItem
import com.viht.assignment.ui.news.view.event.Event
import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class NewsModelKtTest {
    private lateinit var newsModel: NewsModel
    private lateinit var newsModelException: NewsModel
    private lateinit var eventModel: EventModel
    private lateinit var newsRecycleItem: RecyclerItem

    @Before
    fun onSetup() {
        eventModel = EventModel(
            "521eb0fd-7ff4-4d9a-a850-0177740c3493",
            "Logan Crawford",
            "2022-07-08T00:00:00.000Z",
            "Test Jul ", null, null
        )

        newsModel = NewsModel(
            eventDate = "2022-07-07T16:00:00",
            eventDescription = "2022-07-08T00:00:00.000Z: Test Jul ",
            model = eventModel,
            eventType = "event",
            insertedAt = "2022-07-07T15:07:12"
        )

        newsModelException = NewsModel(
            eventDate = "2022-07-07T16:00:00",
            eventDescription = "2022-07-08T00:00:00.000Z: Test Jul ",
            model = eventModel,
            eventType = "eventx",
            insertedAt = "2022-07-07T15:07:12"
        )

        newsRecycleItem = Event(
            id = "1",
            title = "Logan Crawford",
            name = "Test Jul ",
            dateTime = "08 Jul 2022, 12:00 AM",
            clickAdd = false
        )
    }

    @Test
    fun toRecycleItem() {
        mockkStatic("com.viht.assignment.model.NewsModelKt")
        every { newsModel.toRecycleItem() } returns newsRecycleItem
        assertEquals(newsRecycleItem, newsModel.toRecycleItem())
        verify { newsModel.toRecycleItem() }
    }

    @Test
    fun toRecycleItemException() {
        mockkStatic("com.viht.assignment.model.NewsModelKt")
        every { newsModelException.toRecycleItem() }.throws(IllegalStateException("Unknown event type recycle item"))
        assertThrows(IllegalStateException::class.java) { newsModelException.toRecycleItem() }
        verify { newsModelException.toRecycleItem() }

    }
}