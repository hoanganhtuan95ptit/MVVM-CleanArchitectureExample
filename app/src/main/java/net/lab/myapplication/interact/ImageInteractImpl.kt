package net.lab.myapplication.interact

import net.lab.myapplication.data.db.LocalResult
import net.lab.myapplication.data.entities.Image
import net.lab.myapplication.data.repository.ImageRepository

class ImageInteractImpl(imageRepository: ImageRepository) : ImageInteract {
    override suspend fun syncImage() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getImage(): LocalResult<List<Image>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}