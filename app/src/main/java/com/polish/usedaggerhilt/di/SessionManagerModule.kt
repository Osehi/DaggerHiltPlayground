package com.polish.usedaggerhilt.di

import android.content.Context
import android.content.SharedPreferences
import com.polish.usedaggerhilt.util.SharedPreferenceStoreManager
import com.polish.usedaggerhilt.util.SharedPreferenceStoreManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object SessionManagerModule {

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context:Context):SharedPreferences{
        return context.getSharedPreferences("Retrofit Authorization", Context.MODE_PRIVATE)
    }


    @Singleton
    @Provides
    fun providesSharedPreferenceStoreManager(pref:SharedPreferences):SharedPreferenceStoreManager{
        return SharedPreferenceStoreManagerImpl(pref)
    }

    @Singleton
    @Provides
    fun providesInterceptor(chain:Interceptor.Chain, insidePref:SharedPreferenceStoreManager): Response {
        val requestBuilder = chain.request().newBuilder()
        // if the token have been saved
        insidePref.fetchAuthToken()?.let {
            requestBuilder.addHeader("Authorization", "Bearer $it")
        }
        return chain.proceed(requestBuilder.build())
    }

}





