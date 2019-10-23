package net.lab.myapplication.interact

import net.lab.myapplication.data.db.LocalResult
import net.lab.myapplication.data.entities.Image

interface ImageInteract {
    suspend fun syncImage()
    suspend fun getImage(): LocalResult<List<Image>>
}