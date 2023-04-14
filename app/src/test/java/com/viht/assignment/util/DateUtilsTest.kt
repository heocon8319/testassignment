package com.viht.assignment.util

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class DateUtilsTest {

    @Test
    fun formatDateFromDateString() {
        val date = DateUtils.formatDateFromDateString(
            DateUtils.DATE_FORMAT_4,
            DateUtils.DATE_FORMAT_3, "2022-07-08T00:00:00.000Z"
        ) ?: ""
        Assert.assertNotNull(date)
        Assert.assertTrue(date.contains("Jul"))
        Assert.assertTrue(date.contains("2022"))
        Assert.assertTrue(date.contains("12:00 AM"))
        Assert.assertEquals("08 Jul 2022, 12:00 AM", date)
    }
}