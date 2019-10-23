package net.lab.myapplication.di.module

import citigo.core.di.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.lab.myapplication.MainActivity

/**
 * Created by vinh on 2019-05-30
 */
@Module
abstract class UiActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

}