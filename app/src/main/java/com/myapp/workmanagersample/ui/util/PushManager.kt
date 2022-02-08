package com.myapp.workmanagersample.ui.util

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.myapp.workmanagersample.R
import javax.inject.Inject

/**
 * TODO
 *
 */
class PushManager @Inject constructor(private val context: Context){

    /**
     * 通知の種類
     *
     * @property id チャンネルID
     * @property channelName チャンネル名
     * @property title 通知タイトル
     * @property explanation 説明
     */
    enum class CHANNELS(val id: String, val channelName: String, val title: String, val explanation: String) {
        CHANNEL1("show_sample", "長時間Worker","長時間バックグラウンド実施中", "通知サンプル"),
    }

    private val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


    // 通知表示
    fun createForegroundInfoNotification() : Notification {
        createNotificationChannel(CHANNELS.CHANNEL1)
        return NotificationCompat.Builder(context, CHANNELS.CHANNEL1.id)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(CHANNELS.CHANNEL1.title)
            .setOngoing(true)
            .build()
    }

    // チャンネル登録
    private fun createNotificationChannel(channel: CHANNELS) {
        // チャネル作成
        val notificationChannel = NotificationChannel(channel.id, channel.channelName, NotificationManager.IMPORTANCE_LOW)
        notificationManager.createNotificationChannel(notificationChannel)
    }
}
