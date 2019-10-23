package net.lab.myapplication.data.api

import net.lab.myapplication.data.entities.Image
import retrofit2.http.GET

interface ImageApi : InterfaceApi<Image> {

    @GET("image")
    fun getAllImage(): List<Image>
}