package ht.ferit.fjjukic.rma_lv3

import android.app.Application
import android.content.Context

class BirdCounterApplication: Application() {
    companion object {
        lateinit var ApplicationContext: Context
            private set
    }
    override fun onCreate() {
        super.onCreate()
        ApplicationContext = this
    }
}