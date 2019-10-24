package net.lab.myapplication.data.repository

import net.lab.domain.entities.ImageEntity
import net.lab.domain.repository.ImageRepository
import net.lab.myapplication.data.api.ApiProvider
import net.lab.myapplication.data.db.DbProvider

class ImageRepositoryImpl(
    private val apiProvider: ApiProvider,
    private val dbProvider: DbProvider
) : ImageRepository {

    override fun deleteAll() {
        dbProvider.imageDb.deleteAll()
    }

    override fun sync(): List<ImageEntity> {
        return apiProvider.imageApi.getImages()
    }

    override fun save(list: List<ImageEntity>) {
        dbProvider.imageDb.insertOrUpdate(list)
    }

    override fun getImage(): List<ImageEntity> {
        return dbProvider.imageDb.getAll()
    }
}