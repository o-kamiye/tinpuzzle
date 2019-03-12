package com.okamiye.www.tinpuzzle.di

import com.okamiye.www.tinpuzzle.TinPuzzle
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * AppComponent -
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    ActivityInjectionModule::class
])
interface AppComponent: AndroidInjector<TinPuzzle> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: TinPuzzle): Builder
        fun build(): AppComponent
    }

}
