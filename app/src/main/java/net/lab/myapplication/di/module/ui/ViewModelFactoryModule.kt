package net.lab.myapplication.di.module.ui

import dagger.Module
import dagger.Provides
import net.lab.domain.interact.ImageInteract
import net.lab.myapplication.data.db.local.PreferenceHelper
import net.lab.myapplication.ui.viewmodel.factory.ImageViewModelFactory
import javax.inject.Singleton

@Module
class ViewModelFactoryModule {

    @Singleton
    @Provides
    fun provideImageViewModelFactory(imageInteract: ImageInteract, prefHelper: PreferenceHelper): ImageViewModelFactory {
        return ImageViewModelFactory(imageInteract, prefHelper)
    }

}