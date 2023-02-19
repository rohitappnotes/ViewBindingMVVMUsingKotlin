package com.architecture.extensions

import android.app.Activity
import android.app.Fragment
import android.app.FragmentManager
import android.widget.Toast

/**
 * Extensions for [Activity]
 */

fun Activity.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Activity.getFragment(tag: String): Fragment? = fragmentManager.findFragmentByTag(tag)

fun Activity.replaceFragment(containerId: Int, fragment: Fragment, tag: String) {
    fragmentManager.beginTransaction().replace(containerId, fragment, tag).commit()
}

fun Activity.clearFragmentBackStack() {
    if (fragmentManager.backStackEntryCount > 0) {
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}