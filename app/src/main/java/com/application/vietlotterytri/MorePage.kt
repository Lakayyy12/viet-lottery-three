package com.application.vietlotterytri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MorePage : AppCompatActivity() {

    private var btnM : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_page)

        btnM = findViewById(R.id.btnM)
        btnM?.setOnClickListener{
            onBackPressed()
        }

    }
}