package com.architecture.data.repository;

import android.content.Context

public class LocalRepository(var context: Context?) {

    fun getData(): String {
        return "I am local data"
    }
}