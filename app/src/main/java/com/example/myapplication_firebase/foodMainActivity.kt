package com.example.myapplication_firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class foodMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_main)

        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        //回到登入畫面
        button5.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)


            startActivity(intent)
        }

        //進入菜單畫面
        button6.setOnClickListener {

            val intent = Intent(this, MenuActivity::class.java)


            startActivity(intent)
        }

        //進入地圖頁面
       button7.setOnClickListener {

            val intent1 = Intent(this, MapMainActivity::class.java)


            startActivity(intent1)
        }

        //進入訂單頁面
        button8.setOnClickListener {

            val intent2 = Intent(this, bookingMainActivity::class.java)


            startActivity(intent2)
        }













    }


}