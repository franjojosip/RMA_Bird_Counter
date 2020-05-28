package ht.ferit.fjjukic.rma_lv3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var tvCounter: TextView
    private lateinit var btnRedBird: Button
    private lateinit var btnBlueBird: Button
    private lateinit var btnGreenBird: Button
    private lateinit var btnYellowBird: Button
    private lateinit var btnResetColor: Button
    private lateinit var btnResetCount: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        this.tvCounter = findViewById(R.id.tvCounter)
        this.btnRedBird = findViewById(R.id.btnRed)
        this.btnBlueBird = findViewById(R.id.btnBlue)
        this.btnGreenBird = findViewById(R.id.btnGreen)
        this.btnYellowBird = findViewById(R.id.btnYellow)
        this.btnResetColor = findViewById(R.id.btnResetColor)
        this.btnResetCount = findViewById(R.id.btnResetCount)
        setButtonListener()
        setTvCounter()
    }

    private fun setButtonListener() {
        this.btnRedBird.setOnClickListener{
            add(Colors.Red.colorId)
        }
        this.btnBlueBird.setOnClickListener{
            add(Colors.Blue.colorId)
        }
        this.btnGreenBird.setOnClickListener{
            add(Colors.Green.colorId)
        }
        this.btnYellowBird.setOnClickListener{
            add(Colors.Yellow.colorId)
        }
        this.btnResetColor.setOnClickListener{
            resetColor()
        }
        this.btnResetCount.setOnClickListener{
            resetCount()
        }
    }

    private fun setTvCounter() {
        this.tvCounter.text = PreferenceManager().retrieveCount().toString()
        this.tvCounter.setBackgroundColor(ContextCompat.getColor(applicationContext, PreferenceManager().retrieveColor()))
    }

    private fun add(colorId: Int) {
        val count: Int = PreferenceManager().retrieveCount() + 1;
        this.tvCounter.text = count.toString()
        this.tvCounter.setBackgroundColor(ContextCompat.getColor(applicationContext, colorId))
        PreferenceManager().saveCount(count)
        PreferenceManager().saveColor(colorId)
    }

    private fun resetColor() {
        PreferenceManager().saveColor(Colors.Default.colorId)
        this.tvCounter.setBackgroundColor(ContextCompat.getColor(applicationContext, Colors.Default.colorId))
    }

    private fun resetCount(){
        this.tvCounter.text = "0";
        PreferenceManager().saveCount(0)
    }
}
