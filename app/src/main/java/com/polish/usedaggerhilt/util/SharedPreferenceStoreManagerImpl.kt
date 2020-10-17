package com.polish.usedaggerhilt.util

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferenceStoreManagerImpl  (
    val pref:SharedPreferences
): SharedPreferenceStoreManager {

    companion object {
        const val USER_TOKEN = "user_token"
    }


    override fun saveAuthToken(token: String) {
        val editor = pref.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }


    override fun fetchAuthToken(): String? {
        return pref.getString(USER_TOKEN, null)
    }
}