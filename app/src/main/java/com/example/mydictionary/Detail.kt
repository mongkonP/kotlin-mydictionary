package com.example.mydictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val message = intent.getStringExtra(EXTRA_MESSAGE).toString().split("_")

        // Capture the layout's TextView and set the string as its text
        val textView1 = findViewById<TextView>(R.id.detail_textView1).apply {
            text =" คำศัพท์: "+ message[0].toString()
        }
        val textView2 = findViewById<TextView>(R.id.detail_textView2).apply {
            text =" คำอ่าน: "+  message[1].toString()
        }

        val textView3 = findViewById<TextView>(R.id.detail_textView3).apply {
            text =" คำแปล:  \n"+  message[2].toString().replace(",","\n")
        }
    }


}