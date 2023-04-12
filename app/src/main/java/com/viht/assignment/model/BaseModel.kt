package com.viht.assignment.model

interface BaseModel {
    fun execute(jsonString: String?): BaseModel
}