package com.anle.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
//        BugReporting.setInvocationEvents(InstabugInvocationEvent.SCREENSHOT)
    }
}