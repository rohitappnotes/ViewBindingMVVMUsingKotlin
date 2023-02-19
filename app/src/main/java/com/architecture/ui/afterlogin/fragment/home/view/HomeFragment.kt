package com.architecture.ui.afterlogin.fragment.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.architecture.data.repository.LocalRepository
import com.architecture.data.repository.RemoteRepository
import com.architecture.databinding.FragmentHomeBinding
import com.architecture.ui.afterlogin.fragment.home.viewmodel.HomeViewModel
import com.architecture.ui.afterlogin.fragment.home.viewmodel.HomeViewModelFactory
import com.architecture.ui.base.view.BaseFragment
import com.library.navigator.activity.ActivityNavigator
import com.library.navigator.fragment.FragmentNavigator

public class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun getFragmentClassName(): String {
        return HomeFragment::class.java.simpleName
    }

    override fun getActivityNavigator(): ActivityNavigator? {
        return null
    }

    override fun getFragmentNavigator(): FragmentNavigator? {
        return null
    }

    override fun doInOnCreate(savedInstanceState: Bundle?) {
    }

    override fun getViewModel(): HomeViewModel {
        val localRepository = LocalRepository(context)
        val remoteRepository = RemoteRepository(context)
        val factory = HomeViewModelFactory(localRepository, remoteRepository)
        return viewModelProvider<HomeViewModel>(HomeViewModel::class.java, factory)
    }

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
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
        val localObserver: Observer<String> = Observer {
                s -> mViewBinding?.localDataTextView?.text = s
        }
        mViewModel?.local()?.observe(this, localObserver)
        mViewModel?.getLocalData()

        val remoteObserver: Observer<String> = Observer {
                s -> mViewBinding?.remoteDataTextView?.text = s
        }
        mViewModel?.remote()?.observe(this, remoteObserver)
        mViewModel?.getRemoteData()

        val yourNameObserver: Observer<String> = Observer {
                s -> mViewBinding?.youNameTextView?.text = s
        }
        mViewModel?.yourName()?.observe(this, yourNameObserver)
    }

    override fun setupListeners() {
        mViewBinding?.submitMaterialButton?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val name = mViewBinding?.yourNameTextInputEditText?.text.toString().trim()
                mViewModel?.setYourName("Your name is $name")
            }
        })
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