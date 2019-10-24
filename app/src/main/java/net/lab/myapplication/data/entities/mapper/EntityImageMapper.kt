package net.lab.myapplication.data.entities.mapper

import net.lab.domain.entities.ImageEntity
import net.lab.myapplication.data.entities.Image

class EntityImageMapper : Mapper<ImageEntity, Image> {

    override fun mapFromEntity(type: ImageEntity): Image {
        return Image(type.id, type.url)
    }

    override fun mapToEntity(type: Image): ImageEntity {
        return ImageEntity(type.id, type.url)
    }

    override fun mapFromEntity(types: List<ImageEntity>): List<Image> {
        val images = ArrayList<Image>()
        for (type in types) {
            images.add(mapFromEntity(type))
        }
        return images
    }

    override fun mapToEntity(types: List<Image>): List<ImageEntity> {
        val images = ArrayList<ImageEntity>()
        for (type in types) {
            images.add(mapToEntity(type))
        }
        return images
    }
}