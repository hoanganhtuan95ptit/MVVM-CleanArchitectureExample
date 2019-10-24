package net.lab.myapplication.data.api

import net.lab.myapplication.data.entities.Image

interface ImageApi {
    fun getImages(): List<Image>
}