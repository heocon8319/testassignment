package com.viht.assignment.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MsgParamModel(
    val attendanceRecordId: String?,
    val checkInDate: String?,
    val childName: String?,
    val rawCheckInDate: String?,
    val schoolName: String?
) : Parcelable