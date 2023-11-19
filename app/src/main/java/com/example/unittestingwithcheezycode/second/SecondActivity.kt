package com.example.unittestingwithcheezycode.second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.unittestingwithcheezycode.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var text = findViewById<TextView>(R.id.text)
        var message = intent.getStringExtra("message")
        text.text = message
    }
}