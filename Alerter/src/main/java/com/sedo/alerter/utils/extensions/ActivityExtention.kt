package com.sedo.alerter.utils.extensions

import android.app.Activity
import com.sedo.alerter.R
import com.sedo.alerter.ui.AlerterPopup
import com.sedo.alerter.ui.AlerterPopup.Companion.DEFAULT_TIME_TO_DISMISS

fun Activity?.showErrorAlert(
    title: String = this?.getString(R.string.alert_dialog_title) ?: "",
    message: String,
    titleColor: Int = R.color.error_color,
    lineColor: Int = R.color.error_color,
    timeToDismiss: Long = DEFAULT_TIME_TO_DISMISS

) {
    this?.let {
        AlerterPopup(
            context = it,
            title = title,
            description = message,
            titleColor = titleColor,
            lineColor = lineColor,
            timeToDismiss = timeToDismiss
        ).build()
    }
}
