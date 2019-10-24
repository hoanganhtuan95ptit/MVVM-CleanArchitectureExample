package net.lab.myapplication.di.module

import dagger.Module
import dagger.Provides
import net.lab.myapplication.data.api.ApiProvider
import net.lab.myapplication.data.api.ImageApi
import net.lab.myapplication.data.api.retrofit.RetrofitImageApi
import javax.inject.Singleton


@Module
class DataApiModule {

    @Singleton
    @Provides
    fun provideImageApi(): ImageApi {
        return RetrofitImageApi()
    }

    @Singleton
    @Provides
    fun provideApiProvider(imageApi: ImageApi): ApiProvider {
        return ApiProvider(imageApi)
    }
}