package com.architecture.ui.afterlogin.view

import android.os.Bundle
import android.view.LayoutInflater
import com.architecture.R
import com.architecture.data.repository.LocalRepository
import com.architecture.data.repository.RemoteRepository
import com.architecture.databinding.ActivityAfterLoginBinding
import com.architecture.ui.afterlogin.fragment.home.view.HomeFragment
import com.architecture.ui.afterlogin.fragment.profile.view.ProfileFragment
import com.architecture.ui.afterlogin.viewmodel.AfterLoginViewModel
import com.architecture.ui.base.view.BaseActivity
import com.architecture.ui.navigationhost.viewmodel.NavigationHostViewModelFactory
import com.library.navigator.activity.ActivityNavigator
import com.library.navigator.fragment.FragmentNavigator

public class AfterLoginActivity : BaseActivity<ActivityAfterLoginBinding, AfterLoginViewModel>() {

    override fun getActivityClassName(): String {
        return AfterLoginActivity::class.java.simpleName
    }

    override fun getActivityNavigator(): ActivityNavigator? {
        return ActivityNavigator(this)
    }

    override fun getFragmentNavigator(): FragmentNavigator? {
        return FragmentNavigator(supportFragmentManager, R.id.fragmentContainer)
    }

    override fun doInOnCreate(savedInstanceState: Bundle?) {
    }

    override fun getViewModel(): AfterLoginViewModel {
        val localRepository = LocalRepository(this)
        val remoteRepository = RemoteRepository(this)
        val factory = NavigationHostViewModelFactory(localRepository, remoteRepository)
        return viewModelProvider<AfterLoginViewModel>(AfterLoginViewModel::class.java, factory)
    }

    override fun doBeforeSetContentView() {
    }

    override fun getViewBinding(inflater: LayoutInflater): ActivityAfterLoginBinding {
        return ActivityAfterLoginBinding.inflate(inflater)
    }

    override fun setupStatusBar() {
    }

    override fun setupAppBar() {
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
        mViewBinding?.homeFragmentButton?.setOnClickListener {
            val homeFragment = HomeFragment()
            mFragmentNavigator?.push(homeFragment, false, true);
        }

        mViewBinding?.homeFragmentButton?.setOnClickListener {
            val profileFragment = ProfileFragment()
            mFragmentNavigator?.push(profileFragment, false, true);
        }
    }

    override fun setupNavigationBar() {
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
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