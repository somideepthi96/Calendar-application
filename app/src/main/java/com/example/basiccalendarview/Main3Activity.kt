package com.example.basiccalendarview

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.simplecalendardisplay.listviewtext
import kotlinx.android.synthetic.main.activity_main3.*
import java.util.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val summfile = "summaryfile.txt"

        val c = Calendar.getInstance()
        val y = c.get(Calendar.YEAR)
        val m = c.get(Calendar.MONTH)
        val d = c.get(Calendar.DAY_OF_MONTH)

        val home1 = findViewById<ImageView>(R.id.home1)
        home1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        val addsummary = findViewById<EditText>(R.id.addsummary)
        val datedisplay = findViewById<EditText>(R.id.datedisplay)

        val takedate = findViewById<Button>(R.id.takedate)
        takedate.setOnClickListener {
            var dpd2 = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    datedisplay.setText("" + (month + 1) + "/" +  dayOfMonth+ "/" + year)
                }, y, m, d
            )

            dpd2.show()

            savesum.setOnClickListener {


                var filedata = "\n" + datedisplay.text.toString() + "-" + addsummary.text.toString()

                openFileOutput(summfile, Context.MODE_APPEND).use {
                    it.write(filedata.toByteArray())

                    datedisplay.text = null
                    addsummary.text = null
                    val list = openFileInput(summfile).reader()
                    list.readText()

                    val label= findViewById<TextView>(R.id.label)
                    label.text=list.readText()
                    val show=findViewById<Button>(R.id.show)
                    show.setOnClickListener(){
                        val intent= Intent(this, listviewtext::class.java)
                        startActivity(intent)


                    }

                }
            }
            val delete=findViewById<Button>(R.id.delete)
            delete.setOnClickListener(){
                datedisplay.text=null
                addsummary.text=null
                val intent= Intent(this,MainActivity::class.java)
                startActivity(intent)
            }

        }
    }
}
