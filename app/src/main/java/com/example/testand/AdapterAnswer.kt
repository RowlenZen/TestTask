package com.example.testand

import android.text.Html
import java.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class AdapterAnswer() : RecyclerView.Adapter<AdapterAnswer.ViewHolder>() {

    var answers: List<Answer> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_reallyanswers, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return answers.size
    }

    fun updateAnswers(answers: List<Answer>) {
        this.answers = answers
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.combine(answers[position])
    }

    class ViewHolder(element: View) : RecyclerView.ViewHolder(element) {
        val textAnswer = itemView.findViewById<TextView>(R.id.fullText_answer)
        val score = itemView.findViewById<TextView>(R.id.score_number)
        val nameUser = itemView.findViewById<TextView>(R.id.nameUser_answer)
        val dateAnswer = itemView.findViewById<TextView>(R.id.date_answer)
        val dateToNormal: SimpleDateFormat = SimpleDateFormat("dd.MM.yyyy")

        fun combine(item: Answer) {
            val dateEdited: Date = Date(item.creationDate * 1000)
            textAnswer.text = Html.fromHtml(item.body)
            score.text = item.score.toString()
            nameUser.text = item.ownerAnswer.displayName
            dateAnswer.text = dateToNormal.format(dateEdited)

        }
    }
}