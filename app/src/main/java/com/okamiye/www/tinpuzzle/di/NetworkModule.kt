package com.okamiye.www.tinpuzzle.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.okamiye.www.tinpuzzle.TinPuzzle
import com.okamiye.www.tinpuzzle.util.Constants
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * NetworkModule -
 */

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpCache(app: TinPuzzle): Cache {
        val cacheSize: Long = 10 * 1024 * 1024
        return Cache(app.cacheDir, cacheSize)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache): OkHttpClient = OkHttpClient.Builder().cache(cache).build()

    @Provides
    @Singleton
    fun providesRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(Constants.BASE_IMAGE_URL)
                .client(okHttpClient)
                .build()

}
