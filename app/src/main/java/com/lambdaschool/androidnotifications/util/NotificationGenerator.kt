package com.lambdaschool.androidnotifications.util

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import com.lambdaschool.androidnotifications.R
import com.lambdaschool.androidnotifications.ui.FullscreenActivity
import com.lambdaschool.androidnotifications.ui.MainActivity

object NotificationGenerator {
    fun getNotification(context: Context) {

        val notificationIntent = Intent(context, FullscreenActivity::class.java)
        notificationIntent.putExtra("fullscreen_from_notification", "Notification Tapped")
        val pendingNotificationIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_ONE_SHOT)

        val anotherIntent = Intent(context, FullscreenActivity::class.java)
        anotherIntent.putExtra("fullscreen_from_notification", "Action Notification Tapped")
        val pendingAnotherIntent = PendingIntent.getActivity(context, 1, anotherIntent, PendingIntent.FLAG_ONE_SHOT)

        val getID = "${context.packageName}.getchannel"

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Get Notification Channel"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val description = "The Get Notification Channel is working"

            val getID = NotificationChannel (getID, name, importance)
            getID.description = description

            notificationManager.createNotificationChannel(getID)
        }

        val notificationBuilder = NotificationCompat.Builder(context, getID)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setContentTitle("Get Notification")
            .setContentText("Testing the Get Notification")
            .setSmallIcon(android.R.drawable.ic_popup_reminder)
            .setColor(Color.DKGRAY)
            .setDefaults(Notification.DEFAULT_ALL)
            .setContentIntent(pendingNotificationIntent)
            .addAction(R.drawable.abc_ic_arrow_drop_right_black_24dp, "Add Action Notification", pendingAnotherIntent)
            .setAutoCancel(true)
        notificationManager.notify(MainActivity.NOTIFICATION_ID_INSTANT, notificationBuilder.build())
    }
}