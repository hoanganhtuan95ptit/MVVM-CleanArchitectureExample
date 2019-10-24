package net.lab.domain.repository

import net.lab.domain.entities.ImageEntity

interface ImageRepository {
    fun deleteAll()

    fun sync():List<ImageEntity>

    fun save(sync: List<ImageEntity>)

    fun getImage(): List<ImageEntity>
}