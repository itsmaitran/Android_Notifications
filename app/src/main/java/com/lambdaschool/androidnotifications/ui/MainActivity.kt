package com.lambdaschool.androidnotifications.ui

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lambdaschool.androidnotifications.R
import com.lambdaschool.androidnotifications.util.NotificationGenerator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val NOTIFICATION_ID_INSTANT = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_get_notification.setOnClickListener { p0 ->
            NotificationGenerator.getNotification(this)
        }
    }
}
