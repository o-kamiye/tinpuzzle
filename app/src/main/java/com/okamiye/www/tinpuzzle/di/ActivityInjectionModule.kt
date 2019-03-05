package com.okamiye.www.tinpuzzle.di

import com.okamiye.www.tinpuzzle.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * ActivityInjectionModule -
 */
@Module
abstract class ActivityInjectionModule {

    @ContributesAndroidInjector
    abstract fun contributeSplashActivityInjector(): SplashActivity
}