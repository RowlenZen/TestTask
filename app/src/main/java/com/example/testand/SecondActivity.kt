package com.example.testand

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SecondActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen)
        val extras = intent.extras
        //delete later!
        val title = extras?.getString("title")
        val avatar = extras?.getString("avatar")
        val userName = extras?.getString("user_name")
        val date = extras?.getLong("date")
        val questionId = extras?.getLong("questionId")
    }
}