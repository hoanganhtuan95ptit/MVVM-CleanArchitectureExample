package net.lab.myapplication.data.db.realm.enitities.mapper

import net.lab.domain.entities.ImageEntity
import net.lab.myapplication.data.db.realm.enitities.RealmImage
import net.lab.myapplication.data.entities.mapper.Mapper

class RealmImageMapper : Mapper<ImageEntity, RealmImage> {

    override fun mapFromEntity(type: ImageEntity): RealmImage {
        return RealmImage(type.id, type.url)
    }

    override fun mapToEntity(type: RealmImage): ImageEntity {
        return ImageEntity(type.id, type.url)
    }

    override fun mapFromEntity(types: List<ImageEntity>): List<RealmImage> {
        val images = ArrayList<RealmImage>()
        for (type in types) {
            images.add(mapFromEntity(type))
        }
        return images
    }

    override fun mapToEntity(types: List<RealmImage>): List<ImageEntity> {
        val images = ArrayList<ImageEntity>()
        for (type in types) {
            images.add(mapToEntity(type))
        }
        return images
    }
}