package com.architecture.data.repository;

import android.content.Context

public class RemoteRepository(var context: Context?) {

    fun getData(): String {
        return "I am remote data"
    }
}