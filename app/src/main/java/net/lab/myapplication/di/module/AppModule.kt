package net.lab.myapplication.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import net.lab.myapplication.App
import net.lab.myapplication.data.db.local.PreferenceHelper
import javax.inject.Singleton

/**
 * Created by vinh on 2019-05-30
 */
@Module
class AppModule {

    @Provides
    fun provideApp(application: App): Application {
        return application
    }

    @Provides
    fun provideContext(application: App): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun providePreferenceHelper(context: Context): PreferenceHelper {
        return PreferenceHelper(context)
    }

}