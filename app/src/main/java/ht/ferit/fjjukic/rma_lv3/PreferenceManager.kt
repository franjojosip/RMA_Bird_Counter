package ht.ferit.fjjukic.rma_lv3

import android.content.Context

class PreferenceManager {
    companion object {
        const val PREFS_FILE = "birdCounter"
        const val PREFS_KEY_COLOR = "birdColor"
        const val PREFS_KEY_COUNT = "birdCount"
    }
    private val sharedPreferences = BirdCounterApplication.ApplicationContext.getSharedPreferences(
        PREFS_FILE, Context.MODE_PRIVATE
    )

    fun saveColor(colorId: Int) {
        val editor = this.sharedPreferences.edit()
        editor.putInt(PREFS_KEY_COLOR, colorId)
        editor.apply()
    }

    fun retrieveColor(): Int {
        return this.sharedPreferences.getInt(PREFS_KEY_COLOR, Colors.Default.colorId)
    }

    fun saveCount(count: Int) {
        val editor = this.sharedPreferences.edit()
        editor.putInt(PREFS_KEY_COUNT, count)
        editor.apply()
    }

    fun retrieveCount(): Int {
        return this.sharedPreferences.getInt(PREFS_KEY_COUNT, 0)
    }
}