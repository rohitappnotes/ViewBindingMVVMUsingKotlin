package com.architecture.ui.afterlogin.viewmodel

import androidx.lifecycle.MutableLiveData
import com.architecture.data.repository.LocalRepository
import com.architecture.data.repository.RemoteRepository
import com.architecture.ui.base.viewmodel.BaseViewModel

public class AfterLoginViewModel(var localRepository: LocalRepository, var remoteRepository: RemoteRepository) : BaseViewModel() {

    private var localData: MutableLiveData<String>? = null
    private var remoteData: MutableLiveData<String>? = null
    private var yourName: MutableLiveData<String>? = null

    fun local(): MutableLiveData<String>? {
        if (localData == null) {
            localData = MutableLiveData()
        }
        return localData
    }

    fun getLocalData() {
        localData!!.value = localRepository.getData()
    }

    fun remote(): MutableLiveData<String>? {
        if (remoteData == null) {
            remoteData = MutableLiveData()
        }
        return remoteData
    }

    fun getRemoteData() {
        remoteData!!.value = remoteRepository.getData()
    }

    fun yourName(): MutableLiveData<String>? {
        if (yourName == null) {
            yourName = MutableLiveData()
        }
        return yourName
    }

    fun setYourName(name: String?) {
        yourName!!.value = name
    }
}