package com.example.unittestingwithcheezycode.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.unittestingwithcheezycode.R
import com.example.unittestingwithcheezycode.second.FirstActivity
import com.example.unittestingwithcheezycode.second.SecondActivity

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    private val quoteText: TextView
        get() = findViewById(R.id.quoteText)

    private val quoteAuthor: TextView
        get() = findViewById(R.id.quoteAuthor)

    private val textFirstActivity: TextView
        get() = findViewById(R.id.textFirstActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(application)).get(MainViewModel::class.java)
        setQuote(mainViewModel.getQuote())

        textFirstActivity.setOnClickListener {
            var intent = Intent(this@MainActivity, FirstActivity::class.java)
            startActivity(intent)
        }
    }

    fun setQuote(quote: Quote){
        quoteText.text = quote.text
        quoteAuthor.text = quote.author
    }

    fun onPrevious(view: View) {
        setQuote(mainViewModel.previousQuote())
    }

    fun onNext(view: View) {
        setQuote(mainViewModel.nextQuote())
    }

    fun onShare(view: View) {
        try {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, mainViewModel.getQuote().text)
            startActivity(intent)
        }
        catch (exception: Exception) {
            exception.printStackTrace()
        }
    }
}