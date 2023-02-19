package com.architecture.ui.afterlogin.fragment.profile.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.architecture.data.repository.LocalRepository
import com.architecture.data.repository.RemoteRepository
import com.architecture.databinding.FragmentProfileBinding
import com.architecture.ui.afterlogin.fragment.profile.viewmodel.ProfileViewModel
import com.architecture.ui.afterlogin.fragment.profile.viewmodel.ProfileViewModelFactory
import com.architecture.ui.base.view.BaseFragment
import com.library.navigator.activity.ActivityNavigator
import com.library.navigator.fragment.FragmentNavigator

public class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {

    override fun getFragmentClassName(): String {
        return ProfileFragment::class.java.simpleName
    }

    override fun getActivityNavigator(): ActivityNavigator? {
        return null
    }

    override fun getFragmentNavigator(): FragmentNavigator? {
        return null
    }

    override fun doInOnCreate(savedInstanceState: Bundle?) {
    }

    override fun getViewModel(): ProfileViewModel {
        val localRepository = LocalRepository(context)
        val remoteRepository = RemoteRepository(context)
        val factory = ProfileViewModelFactory(localRepository, remoteRepository)
        return viewModelProvider<ProfileViewModel>(ProfileViewModel::class.java, factory)
    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(inflater, container, false)
    }

    override fun init() {
    }

    override fun initView() {
    }

    override fun addTextChangedListener() {
    }

    override fun setOnFocusChangeListener() {
    }

    override fun setupObservers() {
    }

    override fun setupListeners() {
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun showProgressBar() {
    }

    override fun hideProgressBar() {
    }

    override fun showProgressDialog() {
    }

    override fun hideProgressDialog() {
    }
    /***********************************************************************************************
     ********************************************Permission*****************************************
     **********************************************************************************************/

    /***********************************************************************************************
     ********************************************Validations****************************************
     **********************************************************************************************/

    /***********************************************************************************************
     ********************************************Open Activity**************************************
     **********************************************************************************************/

    /***********************************************************************************************
     **********************************************Helper*******************************************
     **********************************************************************************************/
    fun setupCategoryRecyclerView() {
    }
}