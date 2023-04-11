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
                title = "LittleLives + Demo1 (Staging)",
                name = "Event at School level",
                dateTime = "01 May 2022, 12:30 PM"
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
                title = "Dot's Dad",
                name = "(DO NOT EDIT) The Sunny Schoolhouse",
                image = "https://s3.ap-southeast-1.amazonaws.com/six-littlelives-stg/media/eb4d1921-2405-47c4-ba67-9b5672e67da5/5-canh-dong-hanh-toi-mua-hanh-4191-5672-1653965069.jpeg"
            )
        )

        list.add(
            Event(
                id = "4",
                title = "LittleLives + Demo1 (Staging)",
                name = "Event at School level",
                dateTime = "01 Jun 2022, 03:30 PM"
            )
        )

        list.add(
            PortfolioDownLoad(
                id = "5",
                type = "PDF",
                name = "https://s3.ap-southeast-1.amazonaws.com/ll.staging/preview/e1dfc12f-9080-44ee-b5da-a76c5274e57f.pdf"
            )
        )

        list.add(
            CheckInOut(
                id = "6",
                name = "Logan Crawford",
                type = "check in",
                time = "02:30 PM",
                image = "https://media-cache-ap-2.littlelives.com/square/580/contain/ffffff/http://littlecheckin.production.s3-ap-southeast-1.amazonaws.com/users/checkin/521eb0fd-7ff4-4d9a-a850-0177740c3493/checkin_521eb0fd-7ff4-4d9a-a850-0177740c3493_2022_07_07_15_11_55.jpg"
            )
        )

        list.add(
            CheckInOut(
                id = "7",
                name = "Harry Potter",
                type = "check out",
                time = "01:30 PM",
                image = "https://media-cache-ap-2.littlelives.com/square/580/contain/ffffff/http://littlecheckin.production.s3-ap-southeast-1.amazonaws.com/users/checkin/521eb0fd-7ff4-4d9a-a850-0177740c3493/checkin_521eb0fd-7ff4-4d9a-a850-0177740c3493_2022_07_07_15_11_55.jpg"
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
                type = "PDF",
                name = "https://s3.ap-southeast-1.amazonaws.com/ll.staging/preview/e1dfc12f-9080-44ee-b5da-a76c5274e57f.pdf"
            )
        )

        list.add(
            CheckInOut(
                id = "10",
                name = "Vi Huynh",
                type = "check in",
                time = "02:30 PM",
                image = "https://media-cache-ap-2.littlelives.com/square/580/contain/ffffff/http://littlecheckin.production.s3-ap-southeast-1.amazonaws.com/users/checkin/521eb0fd-7ff4-4d9a-a850-0177740c3493/checkin_521eb0fd-7ff4-4d9a-a850-0177740c3493_2022_07_07_15_11_55.jpg"
            )
        )

        list.add(
            PortfolioImage(
                id = "11",
                title = "Dot's Dad",
                name = "(DO NOT EDIT) The Sunny Schoolhouse 1",
                image = "https://s3.ap-southeast-1.amazonaws.com/six-littlelives-stg/media/eb4d1921-2405-47c4-ba67-9b5672e67da5/5-canh-dong-hanh-toi-mua-hanh-4191-5672-1653965069.jpeg"
            )
        )

        list.add(
            Event(
                id = "12",
                title = "LittleLives + Demo1 (Staging)",
                name = "Event at School level",
                dateTime = "01 Jul 2022, 10:30 AM"
            )
        )

        list.add(
            Event(
                id = "13",
                title = "LittleLives + Demo1 (Staging)",
                name = "Event at School level",
                dateTime = "01 Jan 2022, 09:30 AM"
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
                title = "Dot's Dad 2",
                name = "(DO NOT EDIT) The Sunny Schoolhouse",
                image = "https://s3.ap-southeast-1.amazonaws.com/six-littlelives-stg/media/eb4d1921-2405-47c4-ba67-9b5672e67da5/5-canh-dong-hanh-toi-mua-hanh-4191-5672-1653965069.jpeg"
            )
        )

        list.add(
            CheckInOut(
                id = "16",
                name = "Lam Dan",
                type = "check out",
                time = "12:30 PM",
                image = "https://media-cache-ap-2.littlelives.com/square/580/contain/ffffff/http://littlecheckin.production.s3-ap-southeast-1.amazonaws.com/users/checkin/521eb0fd-7ff4-4d9a-a850-0177740c3493/checkin_521eb0fd-7ff4-4d9a-a850-0177740c3493_2022_07_07_15_11_55.jpg"
            )
        )

        list.add(
            PortfolioImage(
                id = "17",
                title = "Dot's Dad 3",
                name = "(DO NOT EDIT) The Sunny Schoolhouse3",
                image = "https://s3.ap-southeast-1.amazonaws.com/six-littlelives-stg/media/eb4d1921-2405-47c4-ba67-9b5672e67da5/5-canh-dong-hanh-toi-mua-hanh-4191-5672-1653965069.jpeg"
            )
        )

        list.add(
            Event(
                id = "18",
                title = "LittleLives + Demo1 (Staging)",
                name = "Event at School level",
                dateTime = "01 Feb 2022, 10:30 AM"
            )
        )

        return list
    }
}