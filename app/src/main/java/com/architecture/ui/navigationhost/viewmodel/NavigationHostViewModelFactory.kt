package com.architecture.ui.navigationhost.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.architecture.data.repository.LocalRepository
import com.architecture.data.repository.RemoteRepository

public class NavigationHostViewModelFactory(var localRepository: LocalRepository, var remoteRepository: RemoteRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NavigationHostViewModel::class.java)) {
            return NavigationHostViewModel(this.localRepository, remoteRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}
