package com.example.testand

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val etSearch by lazy { findViewById<EditText>(R.id.et_search) }
    private val bSearch by lazy { findViewById<Button>(R.id.b_search) }
    private val recycler by lazy { findViewById<RecyclerView>(R.id.rv_element) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val adapter : Adapter = Adapter({element ->
        //второй экран
    })

}