package com.architecture.ui.navigationhost.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.architecture.data.repository.LocalRepository
import com.architecture.data.repository.RemoteRepository
import com.architecture.databinding.ActivityNavigationHostBinding
import com.architecture.ui.base.view.BaseActivity
import com.architecture.ui.navigationhost.viewmodel.NavigationHostViewModel
import com.architecture.ui.navigationhost.viewmodel.NavigationHostViewModelFactory
import com.library.navigator.activity.ActivityNavigator
import com.library.navigator.fragment.FragmentNavigator

public class NavigationHostActivity : BaseActivity<ActivityNavigationHostBinding, NavigationHostViewModel>() {

    override fun getActivityClassName(): String {
        return NavigationHostActivity::class.java.simpleName
    }

    override fun getActivityNavigator(): ActivityNavigator? {
        //return ActivityNavigator(this)
        return null
    }

    override fun getFragmentNavigator(): FragmentNavigator? {
        return null
    }

    override fun doInOnCreate(savedInstanceState: Bundle?) {
        handleIntent(intent)
    }

    @SuppressLint("MissingSuperCall")
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent?) {
    }

    override fun getViewModel(): NavigationHostViewModel {
        val localRepository = LocalRepository(this)
        val remoteRepository = RemoteRepository(this)
        val factory = NavigationHostViewModelFactory(localRepository, remoteRepository)
        return viewModelProvider<NavigationHostViewModel>(NavigationHostViewModel::class.java, factory)
    }

    override fun doBeforeSetContentView() {
    }

    override fun getViewBinding(inflater: LayoutInflater): ActivityNavigationHostBinding {
        return ActivityNavigationHostBinding.inflate(inflater)
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