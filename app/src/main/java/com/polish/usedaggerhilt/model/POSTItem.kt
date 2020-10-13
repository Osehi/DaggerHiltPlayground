package com.polish.usedaggerhilt.model


import com.google.gson.annotations.SerializedName
/*
    this is the domain model
 */
data class POSTItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)