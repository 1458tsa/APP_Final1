package com.example.myapplication_firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class bookingMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_main)

        val EditText1 = findViewById<EditText>(R.id.EditText1)
        val EditText2 = findViewById<EditText>(R.id.EditText2)
        val EditText3 = findViewById<EditText>(R.id.EditText3)
        val EditText4 = findViewById<EditText>(R.id.EditText4)
        val button10 = findViewById<Button>(R.id.button10)


        button10.setOnClickListener {

            //分別輸入四個值:姓名、Email、日期、人數
            val EditText11 = EditText1.text.toString()
            val EditText22 = EditText2.text.toString()
            val EditText33 = EditText3.text.toString()
            val EditText44 = EditText4.text.toString()

            //利用intent送進databaseActivity2
            var intent = Intent(this, databaseActivity2::class.java)

            intent.putExtra("Key4", EditText11)
            intent.putExtra("Key5", EditText22)
            intent.putExtra("Key6", EditText33)
            intent.putExtra("Key7", EditText44)

            startActivity(intent)
        }

    }
}