package com.viht.assignment.ui.base.adapter

interface RecyclerItem {
    val id: String?
    override fun equals(other: Any?): Boolean
}