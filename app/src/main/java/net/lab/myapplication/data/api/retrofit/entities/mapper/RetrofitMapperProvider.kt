package net.lab.myapplication.data.entities.mapper

import net.lab.domain.entities.ImageEntity
import net.lab.myapplication.data.api.retrofit.entities.RetrofitImage

open class RetrofitMapperProvider {
    companion object {
        val mapperImageEntityImage = RetrofitImageMapper() as Mapper<ImageEntity, RetrofitImage>
    }
}