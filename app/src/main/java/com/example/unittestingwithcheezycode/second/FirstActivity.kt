package com.example.unittestingwithcheezycode.second

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.unittestingwithcheezycode.R

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        var editTitle = findViewById<EditText>(R.id.editTitle)
        var editDescription = findViewById<EditText>(R.id.editDescription)
        var btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            var message = "${editTitle.text} || ${editDescription.text}"
            var intent = Intent(this@FirstActivity, SecondActivity::class.java)
            intent.putExtra("message", message)
            startActivity(intent)
        }
    }
}