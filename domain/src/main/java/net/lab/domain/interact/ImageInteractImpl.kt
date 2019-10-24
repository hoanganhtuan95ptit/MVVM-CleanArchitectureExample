package net.lab.domain.interact

import net.lab.domain.entities.ImageEntity
import net.lab.domain.repository.ImageRepository

class ImageInteractImpl(private var mImageRepository: ImageRepository) : ImageInteract {

    override suspend fun sync() {
        mImageRepository.deleteAll()
        mImageRepository.save(mImageRepository.sync())
    }

    override suspend fun getImage(): List<ImageEntity> {
        return mImageRepository.getImage()
    }
}