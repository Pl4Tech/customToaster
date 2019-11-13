package com.pl.customtoster

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ToasterLayerSetup {

    /**
     * setting  up the koin project for injecting toaster Object in views
     * */
    companion object {
        fun setUpKoin(context: Context) {
            startKoin {
                androidContext(context)
                modules(
                    toasterModule
                )
            }
        }
    }
}