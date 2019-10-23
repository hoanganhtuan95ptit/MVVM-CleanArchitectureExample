package net.lab.myapplication.di.module

import dagger.Module
import dagger.Provides
import net.lab.myapplication.data.api.ImageApi
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton


@Module
class DataApiModule {

    @Singleton
    @Provides
    fun provideImageApi(): ImageApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
        return retrofit.create<ImageApi>(ImageApi::class.java)
    }

}