package net.lab.myapplication.di.module

import dagger.Module
import dagger.Provides
import net.lab.domain.interact.ImageInteract
import net.lab.domain.interact.ImageInteractImpl
import net.lab.domain.repository.ImageRepository
import javax.inject.Singleton

@Module
class DomainInteractModule {

    @Singleton
    @Provides
    fun provideImageInteract(imageRepository: ImageRepository): ImageInteract {
        return ImageInteractImpl(imageRepository)
    }

}