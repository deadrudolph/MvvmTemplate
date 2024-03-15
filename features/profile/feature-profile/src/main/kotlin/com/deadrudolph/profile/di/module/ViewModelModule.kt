package com.deadrudolph.profile.di.module

import androidx.lifecycle.ViewModel
import com.deadrudolph.commondi.util.ViewModelKey
import com.deadrudolph.profile.presentation.ui.screen.first.FirstProfileViewModel
import com.deadrudolph.profile.presentation.ui.screen.first.FirstProfileViewModelImpl
import com.deadrudolph.profile.presentation.ui.screen.second.SecondProfileViewModel
import com.deadrudolph.profile.presentation.ui.screen.second.SecondProfileViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FirstProfileViewModel::class)
    fun bindFirstProfileViewModel(viewModel: FirstProfileViewModelImpl): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SecondProfileViewModel::class)
    fun bindSecondProfileViewModel(viewModel: SecondProfileViewModelImpl): ViewModel
}
