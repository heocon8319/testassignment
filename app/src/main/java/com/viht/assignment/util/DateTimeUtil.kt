package com.viht.assignment.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    const val DATE_FORMAT_1 = "hh:mm a"
    const val DATE_FORMAT_2 = "EEE, MMM dd, yyyy"
    const val DATE_FORMAT_3 = "dd MMM yyyy, hh:mm a"
    const val DATE_FORMAT_4 = "yyyy-MM-dd'T'HH:mm:ss"
    const val DATE_FORMAT_5 = "dd LLLL yyyy, hh:mma"

    /**
     * Convert one date format string  to another date format string in android
     *
     * @param inputDateFormat Input SimpleDateFormat
     * @param outputDateFormat Output SimpleDateFormat
     * @param inputDate input Date String
     */

    @Throws(ParseException::class)
    fun formatDateFromDateString(
        inputDateFormat: String?, outputDateFormat: String?,
        inputDate: String?
    ): String? {
        val mParsedDate: Date
        val mOutputDateString: String
        val mInputDateFormat = SimpleDateFormat(inputDateFormat, Locale.getDefault())
        val mOutputDateFormat = SimpleDateFormat(outputDateFormat, Locale.getDefault())
        mParsedDate = mInputDateFormat.parse(inputDate)
        mOutputDateString = mOutputDateFormat.format(mParsedDate)
        return mOutputDateString
    }
}