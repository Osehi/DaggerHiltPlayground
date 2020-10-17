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

}



