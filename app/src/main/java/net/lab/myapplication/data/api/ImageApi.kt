package net.lab.myapplication.data.api

import net.lab.domain.entities.ImageEntity


interface ImageApi {
    fun getImages(): List<ImageEntity>
}