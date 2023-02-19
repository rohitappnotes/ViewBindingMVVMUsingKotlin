package com.architecture.ui.afterlogin.fragment.profile.viewmodel

import com.architecture.data.repository.LocalRepository
import com.architecture.data.repository.RemoteRepository
import com.architecture.ui.base.viewmodel.BaseViewModel

public class ProfileViewModel(var localRepository: LocalRepository, var remoteRepository: RemoteRepository) : BaseViewModel() {
}