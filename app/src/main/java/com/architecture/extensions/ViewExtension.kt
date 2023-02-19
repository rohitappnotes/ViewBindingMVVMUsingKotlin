package com.architecture.extensions

import android.util.Log
import android.view.OrientationEventListener
import android.view.View
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.inputmethod.InputMethodManager

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}



fun View.hide():View {
    visibility = View.GONE
    return this
}

fun View.show():View {
    visibility = View.VISIBLE
    return this
}

fun View.isShowing(): Boolean {
    return visibility == View.VISIBLE
}

fun View.setOnCustomClickListener(listener: (view:View) -> Unit):View{
    var lastclick:Long =0
    var timems = 1000
    setOnClickListener{
        Log.e("abner","time:"+(System.currentTimeMillis() - lastclick))
        if (System.currentTimeMillis() - lastclick >= timems) {
            lastclick = System.currentTimeMillis()
            listener(it)
        }
    }
    return this
}


/**
 * Created by xiaojianjun on 2019-11-29.
 */
/**
 * 弹出软键盘
 */
fun View.showSoftInput() {
    requestFocus()
    val imm = context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

/**
 * 隐藏软键盘
 */
fun View.hideSoftInput() {
    val imm = context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}