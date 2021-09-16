package tw.roy.deng.cathay.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import tw.roy.deng.cathay.CathayApplication
import tw.roy.deng.cathay.di.module.ActivityBuilderModule
import tw.roy.deng.cathay.di.module.AppModule
import tw.roy.deng.cathay.di.module.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {
    fun inject(application: CathayApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: CathayApplication): Builder
        fun appModule(module: AppModule): Builder
        fun build(): AppComponent
    }
}