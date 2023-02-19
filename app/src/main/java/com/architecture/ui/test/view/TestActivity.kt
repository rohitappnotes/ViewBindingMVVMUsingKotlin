package com.architecture.ui.test.view;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import com.architecture.data.repository.LocalRepository
import com.architecture.data.repository.RemoteRepository
import com.architecture.databinding.ActivityTestBinding
import com.architecture.ui.base.view.BaseActivity
import com.architecture.ui.test.viewmodel.TestViewModel
import com.architecture.ui.test.viewmodel.TestViewModelFactory
import com.library.navigator.activity.ActivityNavigator
import com.library.navigator.fragment.FragmentNavigator

public class TestActivity : BaseActivity<ActivityTestBinding, TestViewModel>() {

    override fun getActivityClassName(): String {
        return TestActivity::class.java.simpleName
    }

    override fun getActivityNavigator(): ActivityNavigator? {
        //return ActivityNavigator(this)
        return null
    }

    override fun getFragmentNavigator(): FragmentNavigator? {
        return null
    }

    override fun doInOnCreate(savedInstanceState: Bundle?) {
    }

    override fun getViewModel(): TestViewModel {
        val localRepository = LocalRepository(applicationContext)
        val remoteRepository = RemoteRepository(applicationContext)
        val factory = TestViewModelFactory(localRepository, remoteRepository)
        return viewModelProvider<TestViewModel>(TestViewModel::class.java, factory)
    }

    override fun doBeforeSetContentView() {
    }

    override fun getViewBinding(inflater: LayoutInflater): ActivityTestBinding {
        return ActivityTestBinding.inflate(inflater)
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