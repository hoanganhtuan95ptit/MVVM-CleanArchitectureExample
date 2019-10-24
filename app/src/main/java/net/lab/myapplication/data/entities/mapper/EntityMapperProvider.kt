package net.lab.myapplication.data.entities.mapper

import net.lab.domain.entities.ImageEntity
import net.lab.myapplication.data.entities.Image

open class EntityMapperProvider {
    companion object {
        val mapperImageEntityImage = EntityImageMapper() as Mapper<ImageEntity, Image>
    }
}