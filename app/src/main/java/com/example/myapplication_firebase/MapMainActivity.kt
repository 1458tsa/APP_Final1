package com.example.myapplication_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MapMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_main)

        val openWeb = findViewById<WebView>(R.id.webview1)

        openWeb.webViewClient = WebViewClient()


        openWeb.apply {
            loadUrl("https://goo.gl/maps/Zfp9nPUE1mj6YBtc7")
            settings.javaScriptEnabled = true
        }
    }
}