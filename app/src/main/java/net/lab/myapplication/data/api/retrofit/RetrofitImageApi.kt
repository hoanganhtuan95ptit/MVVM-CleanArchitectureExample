package net.lab.myapplication.data.api.retrofit

import net.lab.myapplication.data.api.ImageApi
import net.lab.myapplication.data.entities.Image
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.GET

class RetrofitImageApi : ImageApi {
    override fun getImages(): List<Image> {
        val okHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(MockInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://stackoverflow.com/questions/")
            .addConverterFactory(JacksonConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(ImageService::class.java).getImages().execute().body()!!
    }

    open interface ImageService {

        @GET("image")
        fun getImages(): Call<List<Image>>
    }
}