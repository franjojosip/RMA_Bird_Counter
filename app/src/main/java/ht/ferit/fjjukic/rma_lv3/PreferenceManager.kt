package ht.ferit.fjjukic.rma_lv3

import android.content.Context
import ht.ferit.fjjukic.rma_lv3.BirdCounterApplication.Companion.ApplicationContext

class PreferenceManager {
    companion object {
        const val PREFS_FILE = "birdCounter"
        const val PREFS_KEY_COLOR = "birdColor"
        const val PREFS_KEY_COUNT = "birdCount"
    }

    fun saveColor(colorId: Int) {
        val sharedPreferences = BirdCounterApplication.ApplicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putInt(PREFS_KEY_COLOR, colorId)
        editor.apply()
    }

    fun retrieveColor(): Int {
        val sharedPreferences = ApplicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        return sharedPreferences.getInt(PREFS_KEY_COLOR, R.color.gray)
    }

    fun saveCount(count: Int) {
        val sharedPreferences = ApplicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putInt(PREFS_KEY_COUNT, count)
        editor.apply()
    }

    fun retrieveCount(): Int {
        val sharedPreferences = ApplicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        return sharedPreferences.getInt(PREFS_KEY_COUNT, 0)
    }

}