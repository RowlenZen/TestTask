package com.example.testand

import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class SecondActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen)
        val extras = intent.extras

        val avatar = extras?.getString("avatar")
        val questionId = extras?.getLong("questionId")

        val titleInScreen = findViewById<TextView>(R.id.title_question)
        val userNameInScreen = findViewById<TextView>(R.id.name_owner)
        val dateInScreen = findViewById<TextView>(R.id.date_question)
        val avatarInScreen = findViewById<ImageView>(R.id.avatar)
        val textQuestion = findViewById<TextView>(R.id.text_question)

        val dateToNormal: SimpleDateFormat = SimpleDateFormat("dd.MM.yyyy")
        val dateEdited: Date = Date((extras?.getLong("date"))!! * 1000)
        dateInScreen.text = dateToNormal.format(dateEdited)
        titleInScreen.text = Html.fromHtml(extras?.getString("title"))
        userNameInScreen.text = extras?.getString("user_name")

        Glide
            .with(avatarInScreen)
            .load(avatar)
            .into(avatarInScreen)

        service.getBodyOfquestion(questionId!!).enqueue(object : Callback<ResponseOfbody> {
            override fun onFailure(call: Call<ResponseOfbody>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<ResponseOfbody>,
                response: Response<ResponseOfbody>
            ) {
                textQuestion.text = Html.fromHtml(response.body()!!.items[0].body)
            }
        })
        service.getAnswers(questionId).enqueue(object : Callback<ResponseOfanswers> {
            override fun onFailure(call: Call<ResponseOfanswers>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<ResponseOfanswers>,
                response: Response<ResponseOfanswers>
            ) {
                val adapterAnswer: AdapterAnswer = AdapterAnswer()
                val recycler = findViewById<RecyclerView>(R.id.rv_answer)
                recycler.adapter = adapterAnswer
                adapterAnswer.updateAnswers(response.body()!!.answers)
            }
        })
    }
}