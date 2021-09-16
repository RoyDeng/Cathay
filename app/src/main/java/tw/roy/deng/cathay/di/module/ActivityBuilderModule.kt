package tw.roy.deng.cathay.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import tw.roy.deng.cathay.ui.MainActivity
import tw.roy.deng.cathay.ui.page1.Page1Fragment
import tw.roy.deng.cathay.ui.page2.Page2Fragment

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [CathayFragmentModule::class])
    abstract fun injectMainActivityFragments(): MainActivity
}

@Module
abstract class CathayFragmentModule {
    @ContributesAndroidInjector
    abstract fun contributePage1Fragment(): Page1Fragment

    @ContributesAndroidInjector
    abstract fun contributePage2Fragment(): Page2Fragment
}