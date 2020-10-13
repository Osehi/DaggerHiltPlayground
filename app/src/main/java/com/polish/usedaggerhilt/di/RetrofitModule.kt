package com.polish.usedaggerhilt.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.polish.usedaggerhilt.constants.Constant
import com.polish.usedaggerhilt.data.api.PostAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun providesGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun providesRetrofit(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    /**
     * this is a retrofit instance for the posts-endpoint
     */
    @Singleton
    @Provides
    fun providePostService(retrofit:Retrofit.Builder):PostAPI {
        return retrofit
            .build()
            .create(PostAPI::class.java)
    }

}