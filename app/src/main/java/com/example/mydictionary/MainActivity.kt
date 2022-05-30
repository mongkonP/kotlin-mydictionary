package com.example.mydictionary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1:Button = findViewById<Button?>(R.id.button1).apply {
           setOnClickListener(){
               val intent1 = Intent(this@MainActivity,Word01::class.java)
               startActivity(intent1)
           }

        }

        val btn2:Button = findViewById<Button?>(R.id.button2).apply {
           setOnClickListener(){
               val intent2 = Intent(this@MainActivity,Word02::class.java)
               startActivity(intent2)
           }

        }
    }
}