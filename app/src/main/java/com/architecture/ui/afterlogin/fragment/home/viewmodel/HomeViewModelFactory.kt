package com.architecture.ui.afterlogin.fragment.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.architecture.data.repository.LocalRepository
import com.architecture.data.repository.RemoteRepository

public class HomeViewModelFactory(var localRepository: LocalRepository, var remoteRepository: RemoteRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(this.localRepository, remoteRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}
