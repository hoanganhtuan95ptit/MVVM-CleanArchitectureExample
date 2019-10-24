package net.lab.domain.interact

import net.lab.domain.entities.ImageEntity

interface ImageInteract {
    suspend fun sync()
    suspend fun getImage(): List<ImageEntity>
}