package com.andreimarcut.sampleapp.buggedabi

import android.app.Activity
import android.os.Bundle
import android.util.Log

class MainActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(MainActivity::javaClass.name, "stringFromJNI()=${stringFromJNI()}")
    }

    /**
     * A native method that is implemented by the 'buggedabi' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'buggedabi' library on application startup.
        init {
            System.loadLibrary("buggedabi")
        }
    }
}