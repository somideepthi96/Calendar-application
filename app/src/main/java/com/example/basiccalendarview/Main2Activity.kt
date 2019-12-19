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
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val file="events.txt"

        val c = Calendar.getInstance()
        val y = c.get(Calendar.YEAR)
        val m = c.get(Calendar.MONTH)
        val d = c.get(Calendar.DAY_OF_MONTH)


        val evname = findViewById<TextView>(R.id.evname)
        val dt = findViewById<EditText>(R.id.dt)



        val dtbutton = findViewById<Button>(R.id.dtbutton)
        dtbutton.setOnClickListener {
            var dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    dt.setText("" + (month + 1) + "/" + dayOfMonth + "/" + year)
                }, y, m, d
            )

            dpd.show()


        }

        save.setOnClickListener {


            var fileContents = "\n" + evname.text.toString()+ "-"       +dt.text.toString()

            openFileOutput(file, Context.MODE_APPEND).use{
                it.write(fileContents.toByteArray())

                evname.text = null
                dt.text=null
                val list = openFileInput(file).reader()

                tvResult.text = list.readText()


            }

            // val mytoast: Toast=Toast.makeText(this,"Event saved\n" ,Toast.LENGTH_LONG)
            //val txttoast:TextView=mytoast.view.findViewById(R.id.message)
            //txttoast.setTextColor(Color.BLUE)
            //txttoast.setBackgroundColor(Color.YELLOW)
            //txttoast.setTextSize(20F)
            //txttoast.gravity=Gravity.CENTER
            //txttoast.isAllCaps=false
            //mytoast.setGravity(Gravity.CENTER or Gravity.BOTTOM, 0,100)
            //mytoast.show()

        }
        val cancel=findViewById<Button>(R.id.cancel)
        cancel.setOnClickListener (){
            evname.text=null
            dt.text=null
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)





        }
        val home=findViewById<ImageView>(R.id.home)
        home.setOnClickListener(){
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }
}
