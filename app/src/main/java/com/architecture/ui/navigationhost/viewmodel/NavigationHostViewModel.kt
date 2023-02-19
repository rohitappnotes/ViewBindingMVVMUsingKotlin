package com.architecture.ui.navigationhost.viewmodel

import com.architecture.data.repository.LocalRepository
import com.architecture.data.repository.RemoteRepository
import com.architecture.ui.base.viewmodel.BaseViewModel

public class NavigationHostViewModel(var localRepository: LocalRepository, var remoteRepository: RemoteRepository) : BaseViewModel() {
}