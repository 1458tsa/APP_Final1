package com.example.myapplication_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


import com.example.myapplication_firebase.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    // Step 1: 先初始化 binding的變數與FirebaseAuth變數
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth


        //Step 2: 點下signUp後需要取得editview的email與password兩個欄位的值
        binding.signUp.setOnClickListener {

            //step 2: 取得email and password
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()



            //step 3: auth內有一個create user using email and password的function
            auth.createUserWithEmailAndPassword(email,password) //把變數email password放進去
                .addOnCompleteListener {
                    //Step 3:在這裡去判斷傳入的值是否有成功，所以要寫一個判斷式
                    if (it.isSuccessful){
                        Log.d("Test","成功註冊")
                        finish()//註冊成功就關閉這個頁面
                    }else{
                        Log.w("Test","註冊失敗", it.exception) //it.exception是把錯誤原因記下來
                        showMessage("註冊會員失敗")//去呼叫showMessage來顯示註冊失敗
                    }
                }

        }
    }


    //Step 3:為了讓使用者知道註冊失敗，所以要寫一個"副程式"showMessage給使用者知道自己註冊失敗的訊息
    private fun showMessage(message: String) {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton("確定") { dialog, which -> }
        alertDialog.show()
    }


}













