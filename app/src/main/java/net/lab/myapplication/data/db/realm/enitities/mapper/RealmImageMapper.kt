package net.lab.myapplication.data.db.realm.enitities.mapper

import net.lab.myapplication.data.db.realm.enitities.RealmImage
import net.lab.myapplication.data.entities.Image
import net.lab.myapplication.data.entities.mapper.Mapper

class RealmImageMapper : Mapper<RealmImage, Image> {

    override fun mapFromEntity(type: RealmImage): Image {
        return Image(type.id, type.url)
    }

    override fun mapToEntity(type: Image): RealmImage {
        return RealmImage(type.id, type.url)
    }

    override fun mapFromEntity(types: List<RealmImage>): List<Image> {
        val images = ArrayList<Image>()
        for (type in types) {
            images.add(mapFromEntity(type))
        }
        return images
    }

    override fun mapToEntity(types: List<Image>): List<RealmImage> {
        val images = ArrayList<RealmImage>()
        for (type in types) {
            images.add(mapToEntity(type))
        }
        return images
    }
}