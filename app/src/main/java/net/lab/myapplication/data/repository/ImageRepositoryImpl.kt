package net.lab.myapplication.data.repository

import net.lab.domain.entities.ImageEntity
import net.lab.domain.repository.ImageRepository
import net.lab.myapplication.data.api.ApiProvider
import net.lab.myapplication.data.db.DbProvider
import net.lab.myapplication.data.entities.mapper.EntityMapperProvider

class ImageRepositoryImpl(
    private val apiProvider: ApiProvider,
    private val dbProvider: DbProvider
) : ImageRepository {

    override fun deleteAll() {
        dbProvider.imageDb.deleteAll()
    }

    override fun sync(): List<ImageEntity> {
        val images = apiProvider.imageApi.getImages()
        return EntityMapperProvider.mapperImageEntityImage.mapToEntity(images)
    }

    override fun save(list: List<ImageEntity>) {
        val images = EntityMapperProvider.mapperImageEntityImage.mapFromEntity(list)
        dbProvider.imageDb.insertOrUpdate(images)
    }

    override fun getImage(): List<ImageEntity> {
        val images = dbProvider.imageDb.getAll()
        return EntityMapperProvider.mapperImageEntityImage.mapToEntity(images)
    }
}