package net.lab.myapplication.di.module

import dagger.Module
import dagger.Provides
import net.lab.domain.repository.ImageRepository
import net.lab.myapplication.data.api.ApiProvider
import net.lab.myapplication.data.db.DbProvider
import net.lab.myapplication.data.repository.ImageRepositoryImpl
import javax.inject.Singleton

@Module
class DomainRepositoryModule {

    @Singleton
    @Provides
    fun provideImageInteract(apiProvider: ApiProvider,dbProvider: DbProvider): ImageRepository {
        return ImageRepositoryImpl(apiProvider,dbProvider)
    }

}