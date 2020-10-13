package com.polish.usedaggerhilt.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
/*
    this class models the data coming from the network
    this is an entity model coming from the network
 */
class POSTNetworkEntity(

    @SerializedName("userId")
    @Expose
    var userId:Int,

    @SerializedName("id")
    @Expose
    var id:Int,

    @SerializedName("title")
    @Expose
    var title:String,

    @SerializedName("body")
    @Expose
    var body:String
) {
}