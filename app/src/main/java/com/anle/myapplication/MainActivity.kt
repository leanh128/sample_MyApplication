package com.anle.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anle.myapplication.databinding.ActivityMainBinding
import com.instabug.bug.BugReporting
import com.instabug.library.invocation.InstabugInvocationEvent

class MainActivity : AppCompatActivity() {
    private val viewBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        viewBinding.openSecondActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
            finish()
        }
        BugReporting.setInvocationEvents(InstabugInvocationEvent.SCREENSHOT)
    }
}