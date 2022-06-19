package com.sedo.alerter.ui

import android.app.Activity
import android.os.CountDownTimer
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.PopupWindow
import androidx.databinding.DataBindingUtil
import com.sedo.alerter.R
import com.sedo.alerter.databinding.PopupAlerterBinding

class AlerterPopup(
    val context: Activity,
    val title: String = context.resources.getString(R.string.alert_dialog_title),
    val description: String = context.resources.getString(R.string.alert_failed),
    val titleColor: Int = R.color.error_color,
    val lineColor: Int = R.color.error_color,
    val timeToDismiss: Long = DEFAULT_TIME_TO_DISMISS
) {

    private lateinit var binding: PopupAlerterBinding
    var popUpDialog: PopupWindow? = null

    fun build() {
        try {
            binding =
                DataBindingUtil.inflate(
                    LayoutInflater.from(context),
                    R.layout.popup_alerter,
                    null,
                    false
                )
            popUpDialog = PopupWindow(
                binding.root,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                false
            )
            popUpDialog?.animationStyle = R.style.DialogAnimations
            binding.dialog = this
            dismissTimer.start()
            context.window.decorView.findViewById<ViewGroup>(android.R.id.content)?.let {
                it.post {
                    popUpDialog?.showAtLocation(it, Gravity.BOTTOM, 0, 0)
                }
            }
            setUpListeners()
        } catch (e: Exception) {

        }
    }

    private fun setUpListeners() {
        binding.imgClose.setOnClickListener {
            dismissTimer.cancel()
            popUpDialog?.dismiss()
        }
    }

    private val dismissTimer = object : CountDownTimer(timeToDismiss, timeToDismiss) {
        override fun onFinish() {
            popUpDialog?.dismiss()
        }

        override fun onTick(millisUntilFinished: Long) {
        }

    }

    companion object {
        const val DEFAULT_TIME_TO_DISMISS: Long = 3000
    }
}
