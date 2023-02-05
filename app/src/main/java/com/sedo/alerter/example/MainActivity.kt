package com.sedo.alerter.example

import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.sedo.alerter.utils.extensions.showErrorAlert

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<MaterialButton>(R.id.btnTest)?.setOnClickListener {
            showErrorAlert(
                title = "Alert",
                message = "alert test",
                gravity = Gravity.TOP
            )
        }
    }

}