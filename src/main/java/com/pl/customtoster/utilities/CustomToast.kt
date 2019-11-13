package com.pl.customtoster.utilities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.pl.customtoster.R

/**
 * A common Toast message with predefined special theme for the whole application
 * @constructor takes param of context in order to attach the toaster to the screen
 */
class CustomToast private constructor(private var mContext: Context) :
    CustomToastInteractor {


    companion object {
        /**
         * default values
         * */
        private var backgroundResId: Int = R.drawable.bg_rounded_toast
        private var textColorResId: Int = R.color.colorToastTxt
        const val LENGTH_SHORT: Int = 0
        const val LENGTH_LONG: Int = 1
    }

    class Builder {
        /**
         * setter methods for color and background color that takes resource id and assign value
         * @param resId which is a reference to a resource to be used later
         * */
        fun setBackGroundRes(resId: Int) = apply { backgroundResId = resId }
        fun setTextColorRes(resId: Int) = apply { textColorResId = resId }

        /**
         * @param context which is a context of activity or fragment
         * @return CustomToast Object to be used as a singleton reference to display toast message
         * */
        fun build(context: Context): CustomToast {
            return CustomToast(context)
        }
    }

    /**
     * override the show message for displaying Toast message and apply the predefined settings
     * the method takes two params: the message and whether the duration is LONG or SHORT
     * @param toastMSG the message to be displayed
     * @param toastDuration as indicator for (SHORT or LONG showing Period )
     * */
    override fun show(toastMSG: Int, toastDuration: Int) {
        val inflater: LayoutInflater?
        var toastView: View? = null
        try {
            inflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            if (inflater != null) {
                toastView = inflater.inflate(R.layout.layout_toast, null)
                toastView.background = mContext.resources.getDrawable(backgroundResId)
            }
            val toast = Toast(mContext)
            toast.view = toastView


            /**(just a fake number) 1 is Long period & 0 is Short Period.  */
            if (toastDuration == LENGTH_SHORT) {
                toast.duration = Toast.LENGTH_SHORT
            } else {
                toast.duration = Toast.LENGTH_LONG
            }

            if (toastView != null) {
                val toastText = toastView.findViewById<TextView>(R.id.toast_text)
                toastText.text = mContext.getString(toastMSG)
                toastText.setTextColor(mContext.resources.getColor(textColorResId))
            }

            toast.show()
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }

    }

    /**
     * override the show message for displaying Toast message and apply the predefined settings
     * the method takes two params: the message and whether the duration is LONG or SHORT
     * @param toastMSG the message to be displayed
     * @param toastDuration as indicator for (SHORT or LONG showing Period )
     * */
    override fun show(toastMSG: String, toastDuration: Int) {

        val inflater: LayoutInflater?
        var toastView: View? = null
        try {

            inflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            if (inflater != null) {
                toastView = inflater.inflate(R.layout.layout_toast, null)
                toastView.background = mContext.resources.getDrawable(backgroundResId)
            }
            val toast = Toast(mContext)
            toast.view = toastView

            /**(just a fake number) 1 is Long period & 0 is Short Period.  */
            if (toastDuration == LENGTH_SHORT) {
                toast.duration = Toast.LENGTH_SHORT
            } else {
                toast.duration = Toast.LENGTH_LONG
            }

            if (toastView != null) {
                val toastText = toastView.findViewById<TextView>(R.id.toast_text)
                toastText.text = toastMSG
                toastText.setTextColor(mContext.resources.getColor(textColorResId))
            }

            toast.show()
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }

    }
}
