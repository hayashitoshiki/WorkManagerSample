package com.myapp.workmanagersample.data.local.preferences

import android.content.Context
import javax.inject.Inject

class PreferenceManager @Inject constructor(val context: Context) {

    /**
     * Int型格納
     *
     * @param key   キー
     * @param value 格納する値
     */
    fun setInt(
        key: PreferenceKey.IntKey,
        value: Int
    ) {
        val preferences = context.getSharedPreferences("selfUpdateRoutine", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putInt(key.name, value)
        editor.apply()
    }

    /**
     * Int型取得
     *
     * @param key キー
     * @return キーに紐づくInt型オブジェクト
     */
    fun getInt(key: PreferenceKey.IntKey): Int {
        val defaultValue = 0
        val preferences = context.getSharedPreferences("selfUpdateRoutine", Context.MODE_PRIVATE)
        return preferences.getInt(key.name, defaultValue)
    }

}
