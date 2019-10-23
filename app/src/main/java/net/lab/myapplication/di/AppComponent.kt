package net.lab.myapplication.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import net.lab.myapplication.App
import net.lab.myapplication.di.module.*
import javax.inject.Singleton

/**
 * Created by vinh on 2019-05-30
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        DataApiModule::class,
        DataDbModule::class,
        DomainRepositoryModule::class,
        DomainInteractModule::class,
        UiActivityModule::class,
        UiFragmentModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}