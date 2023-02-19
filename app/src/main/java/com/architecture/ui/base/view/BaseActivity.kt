package com.architecture.ui.base.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.architecture.R
import com.architecture.ui.base.viewmodel.BaseViewModel
import com.google.android.material.snackbar.Snackbar
import com.library.networkconnectivity.NetworkReceiver
import com.library.networkconnectivity.NetworkStateChangeListener
import com.library.networkconnectivity.NetworkStateChangeReceiver

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : AppCompatActivity(), BaseActivityView {

    /**
     * TAG
     */
    protected open lateinit var mTag: String

    /**
     * My Lib Activity Navigator
     */
    protected open var mActivityNavigator: com.library.navigator.activity.ActivityNavigator? = null

    /**
     * My Lib Fragment Navigator
     */
    protected open var mFragmentNavigator: com.library.navigator.fragment.FragmentNavigator? = null

    /**
     * ViewModel
     */
    protected open var mViewModel: VM? = null

    /**
     * ViewBinding
     */
    protected open var mViewBinding: VB? = null

    /**
     * View
     */
    protected open var rootView: View? = null

    /**
     * You need override this method for activity Logcat tag
     * Example :
     * override fun getActivityClassName(): String {
     *   return TestActivity::class.java.simpleName
     * }
     */
    protected abstract fun getActivityClassName(): String

    /**
     * You need override this method, you can use it for navigate to another activity, send and receive
     * data (bundle, serializable, parcelable) between activity
     */
    protected abstract fun getActivityNavigator(): com.library.navigator.activity.ActivityNavigator?

    /**
     * You need override this method, you can use it for add or replace fragment in activity or fragment,
     * send and receive data (bundle, serializable, parcelable) between activity
     */
    protected abstract fun getFragmentNavigator(): com.library.navigator.fragment.FragmentNavigator?

    /**
     * You need override this method, you can use it for bundle, handleIntent(intent) etc.,
     */
    protected abstract fun doInOnCreate(savedInstanceState: Bundle?)

    /**
     * You need override this method.
     * Example :
     * override fun getViewModel(): TestViewModel {
     *   val localRepository = LocalRepository(this)
     *   val remoteRepository = RemoteRepository(this)
     *   val factory = TestViewModelFactory(localRepository, remoteRepository)
     *   return viewModelProvider<TestViewModel>(TestViewModel::class.java, factory)
     * }
     */
    protected abstract fun getViewModel(): VM

    /**
     * Here you can setting a theme dynamically for activity
     * Example :
     *  override fun onCreate(savedInstanceState: Bundle?) {
     *      super.onCreate(savedInstanceState)
     *      //The call goes right after super.onCreate() and before setContentView()
     *      setTheme(android.R.style.Theme_Translucent_NoTitleBar)
     *      setContentView(R.layout.activity_main)
     *  }
     */
    protected abstract fun doBeforeSetContentView()

    /**
     * You need override this method.
     * Example :
     * override fun getViewBinding(inflater: LayoutInflater): ActivityTestBinding {
     *     return ActivityTestBinding.inflate(inflater)
     * }
     */
    protected abstract fun getViewBinding(inflater: LayoutInflater): VB

    protected abstract fun setupStatusBar()
    protected abstract fun setupAppBar()
    protected abstract fun init()
    protected abstract fun initView()
    protected abstract fun addTextChangedListener()
    protected abstract fun setOnFocusChangeListener()
    protected abstract fun setupObservers()
    protected abstract fun setupListeners()
    protected abstract fun setupNavigationBar()

    private fun initTag() {
        mTag = getActivityClassName()
        if (mTag.length > 23) {
            mTag = mTag.substring(0, 22) // first 22 chars
        }
    }

    private fun initViewModel() {
        mViewModel = getViewModel()
    }

    private fun initViewBinding(inflater: LayoutInflater) {
        mViewBinding = getViewBinding(inflater)
        rootView = mViewBinding?.root
    }

    private lateinit var networkReceiver: NetworkReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initTag()
        Log.i(mTag, "onCreate(Bundle savedInstanceState)")

        networkReceiver = NetworkReceiver(this)
        checkInternetConnection()

        mActivityNavigator = getActivityNavigator()
        mFragmentNavigator = getFragmentNavigator()

        doInOnCreate(savedInstanceState)

        initViewModel()

        doBeforeSetContentView()

        initViewBinding(layoutInflater)
        setContentView(rootView)

        setupStatusBar()
        setupAppBar()
        init()
        initView()
        addTextChangedListener()
        setOnFocusChangeListener()
        setupObservers()
        setupListeners()
        setupNavigationBar()
    }

    override fun onStart() {
        super.onStart()
        Log.i(mTag, "onStart()")
    }

    override fun onRestart() { /* Only called after onStop() */
        super.onRestart()
        Log.i(mTag, "onRestart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(mTag, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i(mTag, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(mTag, "onStop()")
    }

    override fun onDestroy() {
        if (null != mViewModel) {
            mViewModel = null
        }
        if (null != mViewBinding) {
            mViewBinding = null
        }
        if (null != rootView) {
            rootView = null
        }
        super.onDestroy()
        Log.i(mTag, "onDestroy()")
    }

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
        Log.i(mTag, "startActivity(Intent intent)")
        overridePendingTransitionEnter()
    }

    override fun startActivityForResult(intent: Intent?, requestCode: Int) {
        super.startActivityForResult(intent, requestCode)
        Log.i(mTag, "startActivityForResult(Intent intent, int requestCode)")
        overridePendingTransitionEnter()
    }

    override fun finish() {
        super.finish()
        Log.i(mTag, "finish()")
        overridePendingTransitionExit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.i(mTag, "onBackPressed()")
    }
    /***********************************************************************************************
     ******************************************App Language*****************************************
     **********************************************************************************************/

    /***********************************************************************************************
     *************************************Implemented Method****************************************
     **********************************************************************************************/
    override fun showShortToast(message: String) {
        Log.i(mTag, message)
        toast(message, Toast.LENGTH_SHORT)
    }

    override fun showShortToast(messageResId: Int) {
        Log.i(mTag, getString(messageResId))
        toast(getString(messageResId), Toast.LENGTH_SHORT);
    }

    override fun showLongToast(message: String) {
        Log.i(mTag, message)
        toast(message, Toast.LENGTH_LONG);
    }

    override fun showLongToast(messageResId: Int) {
        Log.i(mTag, getString(messageResId))
        toast(getString(messageResId), Toast.LENGTH_LONG);
    }

    override fun showIndefiniteSnackBar(parent: View, message: String, actionText: String?, onClickListener: View.OnClickListener?) {
        Log.i(mTag, message)
        snackBar(
            parent,
            message,
            Snackbar.LENGTH_INDEFINITE,
            actionText,
            onClickListener
        )
    }

    override fun showIndefiniteSnackBar(parent: View, messageResId: Int, actionText: String?, onClickListener: View.OnClickListener?) {
        Log.i(mTag, getString(messageResId))
        snackBar(
            parent,
            getString(messageResId),
            Snackbar.LENGTH_INDEFINITE,
            actionText,
            onClickListener
        )
    }

    override fun showShortSnackBar(parent: View, message: String, actionText: String?, onClickListener: View.OnClickListener?) {
        Log.i(mTag, message)
        snackBar(parent, message, Snackbar.LENGTH_SHORT, actionText, onClickListener);
    }

    override fun showShortSnackBar(parent: View, messageResId: Int, actionText: String?, onClickListener: View.OnClickListener?) {
        Log.i(mTag, getString(messageResId))
        snackBar(
            parent,
            getString(messageResId),
            Snackbar.LENGTH_SHORT,
            actionText,
            onClickListener
        );
    }

    override fun showLongSnackBar(parent: View, message: String, actionText: String?, onClickListener: View.OnClickListener?) {
        Log.i(mTag, message)
        snackBar(parent, message, Snackbar.LENGTH_LONG, actionText, onClickListener);
    }

    override fun showLongSnackBar(parent: View, messageResId: Int, actionText: String?, onClickListener: View.OnClickListener?) {
        Log.i(mTag, getString(messageResId))
        snackBar(
            parent,
            getString(messageResId),
            Snackbar.LENGTH_LONG,
            actionText,
            onClickListener
        );
    }

    override fun setVisible(vararg views: View) {
        for (v in views) {
            v.visibility = View.VISIBLE
        }
    }

    override fun setInVisible(vararg views: View) {
        for (v in views) {
            v.visibility = View.INVISIBLE
        }
    }

    override fun setGone(vararg views: View) {
        for (v in views) {
            v.visibility = View.GONE
        }
    }

    override fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
    /***********************************************************************************************
     ****************************************ViewModel Helper***************************************
     **********************************************************************************************/
    protected open fun <VMC : BaseViewModel?> viewModelProvider(viewModelClass: Class<VM>): VM? {
        return ViewModelProvider(this).get(viewModelClass)
    }

    protected open fun <VMC : BaseViewModel?> viewModelProvider(viewModelClass: Class<VM>, factory: ViewModelProvider.Factory): VM {
        return ViewModelProvider(this, factory).get(viewModelClass)
    }
    /***********************************************************************************************
     *****************************************StatusBar Helper**************************************
     **********************************************************************************************/

    /***********************************************************************************************
     *****************************************AppBar Helper*****************************************
     **********************************************************************************************/
    protected open fun setupToolBar(toolbar: Toolbar?, @ColorInt background: Int, navigationIcon: Int, title: Int) {
        if (toolbar != null) {
            setSupportActionBar(toolbar)
            toolbar.setBackgroundColor(background)
            toolbar.navigationIcon = AppCompatResources.getDrawable(applicationContext, navigationIcon)
            toolbar.setNavigationOnClickListener(View.OnClickListener {
                onBackPressed()
            })
            toolbar.title = resources.getString(title)
        }
    }
    /***********************************************************************************************
     **************************************NavigationBar Helper*************************************
     **********************************************************************************************/

    /***********************************************************************************************
     ********************************************Helper*********************************************
     **********************************************************************************************/
    protected open fun overridePendingTransitionEnter() {
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left)
    }

    protected open fun overridePendingTransitionExit() {
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right)
    }

    private fun checkInternetConnection() {
        NetworkStateChangeReceiver.setNetworkStateChangeListener(object :
            NetworkStateChangeListener {
            override fun networkAvailable() {
                Log.i(mTag, "INTERNET CONNECT")
                showShortToast("Internet Connect")
            }

            override fun networkUnavailable() {
                Log.i(mTag, "INTERNET DISCONNECT")
                showShortToast("Internet Disconnect")
            }
        })
    }

    private fun toast(message: String, length: Int) {
        val toast = Toast.makeText(applicationContext, message, length)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }

    private fun snackBar(parent: View, snackBarText: String, length: Int, actionText: String?, onClickListener: View.OnClickListener?) {
        val snackBar = Snackbar.make(parent, snackBarText, length)
        snackBar.setBackgroundTint(Color.parseColor("#FF0000")) // background red
        snackBar.setTextColor(Color.parseColor("#FFFFFF")) // snackBarText white
        if (actionText != null && onClickListener != null) {
            snackBar.setActionTextColor(Color.parseColor("#008505")) // actionText green
            snackBar.setAction(actionText, onClickListener)
        }
        snackBar.show()
    }
}