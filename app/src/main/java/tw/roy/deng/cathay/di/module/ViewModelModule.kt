package tw.roy.deng.cathay.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import tw.roy.deng.cathay.factory.ViewModelKey
import tw.roy.deng.cathay.factory.ViewModelProviderFactory
import tw.roy.deng.cathay.ui.page1.Page1FragmentViewModel

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(
        factory: ViewModelProviderFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(Page1FragmentViewModel::class)
    abstract fun providesPage1FragmentViewModel(
        viewModel: Page1FragmentViewModel
    ): ViewModel
}