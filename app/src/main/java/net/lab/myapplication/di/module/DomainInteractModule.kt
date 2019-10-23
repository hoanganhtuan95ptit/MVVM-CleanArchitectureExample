package net.lab.myapplication.di.module

import dagger.Module
import dagger.Provides
import net.lab.myapplication.data.repository.ImageRepository
import net.lab.myapplication.interact.ImageInteract
import net.lab.myapplication.interact.ImageInteractImpl
import javax.inject.Singleton

@Module
class DomainInteractModule {

    @Singleton
    @Provides
    fun provideImageInteract(imageRepository: ImageRepository): ImageInteract {
        return ImageInteractImpl(imageRepository)
    }

}