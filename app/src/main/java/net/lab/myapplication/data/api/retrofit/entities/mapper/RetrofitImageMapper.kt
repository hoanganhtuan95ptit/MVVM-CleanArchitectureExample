package net.lab.myapplication.data.entities.mapper

import net.lab.domain.entities.ImageEntity
import net.lab.myapplication.data.api.retrofit.entities.RetrofitImage

class RetrofitImageMapper : Mapper<ImageEntity, RetrofitImage> {

    override fun mapFromEntity(type: ImageEntity): RetrofitImage {
        return RetrofitImage(type.id, type.url)
    }

    override fun mapToEntity(type: RetrofitImage): ImageEntity {
        return ImageEntity(type.id, type.url)
    }

    override fun mapFromEntity(types: List<ImageEntity>): List<RetrofitImage> {
        val images = ArrayList<RetrofitImage>()
        for (type in types) {
            images.add(mapFromEntity(type))
        }
        return images
    }

    override fun mapToEntity(types: List<RetrofitImage>): List<ImageEntity> {
        val images = ArrayList<ImageEntity>()
        for (type in types) {
            images.add(mapToEntity(type))
        }
        return images
    }
}