package com.viht.assignment.ui.news

import com.viht.assignment.ui.base.adapter.RecyclerItem
import com.viht.assignment.ui.news.view.checkinout.CheckInOut
import com.viht.assignment.ui.news.view.event.Event
import com.viht.assignment.ui.news.view.header.Header
import com.viht.assignment.ui.news.view.portfoliodownload.PortfolioDownLoad
import com.viht.assignment.ui.news.view.portfolioimage.PortfolioImage

object ExampleData {

    fun createList(): List<RecyclerItem> {
        val list = ArrayList<RecyclerItem>()

        list.add(
            Event(
                id = "1",
                text = "Movie 1"
            )
        )

        list.add(
            Header(
                id = "2",
                date = "20/3/2023"
            )
        )

        list.add(
            PortfolioImage(
                id = "3",
                text = "Advertising text portfolio img"
            )
        )

        list.add(
            Event(
                id = "4",
                text = "Event greeting"
            )
        )

        list.add(
            PortfolioDownLoad(
                id = "5",
                text = "Advertising text portfolio download"
            )
        )

        list.add(
            CheckInOut(
                id = "6",
                text = "Check in"
            )
        )

        list.add(
            CheckInOut(
                id = "7",
                text = "Check out"
            )
        )

        list.add(
            Header(
                id = "8",
                date = "20/3/2023"
            )
        )

        list.add(
            PortfolioDownLoad(
                id = "9",
                text = "Advertising text portfolio download"
            )
        )

        list.add(
            CheckInOut(
                id = "10",
                text = "Check in"
            )
        )

        list.add(
            PortfolioImage(
                id = "11",
                text = "Advertising text portfolio img"
            )
        )

        list.add(
            Event(
                id = "12",
                text = "Event greeting"
            )
        )

        list.add(
            Event(
                id = "13",
                text = "Movie 1"
            )
        )

        list.add(
            Header(
                id = "14",
                date = "20/3/2023"
            )
        )

        list.add(
            PortfolioImage(
                id = "15",
                text = "Advertising text portfolio img"
            )
        )

        list.add(
            CheckInOut(
                id = "16",
                text = "Check in"
            )
        )

        list.add(
            PortfolioImage(
                id = "17",
                text = "Advertising text portfolio img"
            )
        )

        list.add(
            Event(
                id = "18",
                text = "Event greeting"
            )
        )

        return list
    }
}