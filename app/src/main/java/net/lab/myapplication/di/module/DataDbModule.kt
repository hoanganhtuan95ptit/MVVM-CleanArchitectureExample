package net.lab.myapplication.di.module

import dagger.Module
import dagger.Provides
import net.lab.myapplication.data.db.DbProvider
import net.lab.myapplication.data.db.ImageDb
import net.lab.myapplication.data.db.realm.RealmImageDb
import javax.inject.Singleton

@Module
class DataDbModule {

    @Singleton
    @Provides
    fun provideImageDb(): ImageDb {
        return RealmImageDb()
    }

    @Singleton
    @Provides
    fun provideDbProvider(imageDb: ImageDb): DbProvider {
        return DbProvider(imageDb)
    }

}