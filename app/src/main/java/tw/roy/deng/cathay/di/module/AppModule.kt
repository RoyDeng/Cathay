package tw.roy.deng.cathay.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import tw.roy.deng.cathay.CathayApplication
import javax.inject.Singleton

@Module
class AppModule(private val application: CathayApplication, private val context: Context) {
    @Provides
    @Singleton
    fun providesApplication(): Application = application

    @Provides
    @Singleton
    fun providesCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO
}