package net.lab.myapplication.di.module.ui

import citigo.core.di.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.lab.myapplication.ui.activity.MainActivity

/**
 * Created by vinh on 2019-05-30
 */
@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

}