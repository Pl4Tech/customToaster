package com.pl.customtoster

import android.content.Context
import com.pl.customtoster.utilities.CustomToast
import com.pl.customtoster.utilities.CustomToastInteractor
import org.koin.dsl.module

val toasterModule = module {

    /**
     * providing custom toaster object to be injected later in the view
     * @param context of application or activity
     * @return CustomToastInteractor as singleton class
     * */
    single<CustomToastInteractor> { provideCustomToastInteractor(get()) }
}

/**
 * function that provides the and builds Toaster Object with a predefined text
 * @param context
 * @return CustomToastInteractor an object of Custom Toaster Class to be used later
 * */
fun provideCustomToastInteractor(context: Context): CustomToastInteractor =
    CustomToast.Builder().setBackGroundRes(R.drawable.bg_rounded_toast)
        .setTextColorRes(R.color.colorToastTxt).build(context)
