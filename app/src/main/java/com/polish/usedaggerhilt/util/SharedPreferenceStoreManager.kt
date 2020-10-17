package com.polish.usedaggerhilt.util

interface SharedPreferenceStoreManager {

    fun saveAuthToken(token:String)

    fun fetchAuthToken():String?

}