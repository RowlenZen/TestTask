package com.example.testand

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val etSearch by lazy { findViewById<EditText>(R.id.et_search) }
    private val bSearch by lazy { findViewById<Button>(R.id.b_search) }
    private val recycler by lazy { findViewById<RecyclerView>(R.id.rv_element) }
    private val adapter: Adapter = Adapter({ element ->
        val elementIntent = Intent(this, SecondActivity::class.java)
        elementIntent.putExtra("title", element.title)
        elementIntent.putExtra("avatar", element.owner.profileImage)
        elementIntent.putExtra("user_name",element.owner.displayName)
        elementIntent.putExtra("date",element.creationDate)
        elementIntent.putExtra("questionId", element.question_id)
        startActivity(elementIntent)
    }, { link ->
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(browserIntent)
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.adapter = adapter
        clickButton()
    }

    private fun clickButton() {
        bSearch.setOnClickListener {
            service.getQuestions(etSearch.text.toString()).enqueue(object : Callback<ResponseSearch> {
                override fun onFailure(call: Call<ResponseSearch>, t: Throwable) {
                    t.printStackTrace()
                }

                override fun onResponse(
                    call: Call<ResponseSearch>,
                    response: Response<ResponseSearch>
                ) {
                    adapter.updateList(response.body()!!.item)
                }

            })
        }
    }

}