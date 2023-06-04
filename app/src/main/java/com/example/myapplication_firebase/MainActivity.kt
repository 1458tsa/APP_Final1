package com.example.myapplication_firebase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

import com.example.myapplication_firebase.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseUser

class  MainActivity : AppCompatActivity() {

    //Step 1: 初始化FirebaseAuth
    private lateinit var auth: FirebaseAuth

    //Step 1:先從註冊這個功能開始寫->先初始化一個資料鏈結的部分
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //** Step 2: 去設定我們要去啟動的RegisterActivity **
        //Step 2-1: 初始化FirebaseAuth->初始化auth
        auth = Firebase.auth

        //Step 2-2:先從註冊這個功能開始寫->初始化binding要鏈結的layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Step 2-3:先從註冊這個功能開始寫->先宣告要在"signUp"這個button內寫監聽程式，
        binding.signUp.setOnClickListener {

            // Step 2-4: 宣告一個intent變數，使用Intent去開啟一個我們自己寫好的RegisterActivity
            var intent = Intent(this, RegisterActivity::class.java)
            // Step 2-5: start這個Activity
            startActivity(intent)
        }



        //Step 3-1: 設計登入的button
        binding.signIn.setOnClickListener {
            if (binding.email.text.toString().isEmpty()) {
                showMessage("請輸入帳號")
            } else if (binding.password.text.toString().isEmpty()) {
                showMessage("請輸入密碼")
            } else {
                signIn()
            }

        }

        //Step 4: 設計logout button功能
        binding.logout.setOnClickListener {
            auth.signOut()

            val user = Firebase.auth.currentUser
            updateUI(user)
        }


    }

    //Step 3-2: 設計登入的button->寫一個登入認證失敗的判斷式
    private fun signIn() {
        val email = binding.email.text.toString()
        val password = binding.password.text.toString()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    //Log.d("signInWithEmail:success")
                    println("---------signInWithEmail:success-----------")
                    val user = auth.currentUser
                    updateUI(user)

                } else {
                    it.exception?.message?.let {  }
                    println("---------error---------------")
                    showMessage("登入失敗，帳號或密碼錯誤")
                    updateUI(null)
                }
            }
    }

    //Step 6: 確認更新登入的user狀況
    private fun updateUI(user: FirebaseUser?) {


        if (user != null) {
            //已登入
            binding.email.visibility = View.GONE
            binding.password.visibility = View.GONE
            binding.signIn.visibility = View.GONE
            binding.signUp.visibility = View.GONE
            binding.logout.visibility = View.VISIBLE

            var intent = Intent(this, foodMainActivity::class.java)
            startActivity(intent)

        } else {
            //未登入
            binding.email.visibility = View.VISIBLE
            binding.password.visibility = View.VISIBLE
            binding.signIn.visibility = View.VISIBLE
            binding.signUp.visibility = View.VISIBLE
            binding.logout.visibility = View.GONE
        }
    }
    //Step 3-3: 設計登入的button->設計一個給使用者確認的message
    private fun showMessage(message: String) {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton("確定") { dialog, which -> }
        alertDialog.show()


    }
}
