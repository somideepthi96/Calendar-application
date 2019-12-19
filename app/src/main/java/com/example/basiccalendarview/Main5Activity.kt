package com.example.basiccalendarview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class Main5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        //create a date string.
        val date_n = SimpleDateFormat("MMMM , dd - yyyy EEEE", Locale.getDefault()).format(Date())
        //get hold of textview.
        var date = findViewById(R.id.date) as TextView
        date.setText(date_n)

        date.setOnClickListener(){
            val intent= Intent(this,Main2Activity::class.java)
            startActivity(intent)
        }
        val home3=findViewById<ImageView>(R.id.home3)
        home3.setOnClickListener(){
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}
