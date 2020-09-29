package com.example.testand

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adaper2() : RecyclerView.Adapter<Adapter.ViewHolder>(){

    var answers : List<Answer> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_answer, parent, false)
        return Adapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return answers.size
    }

    fun updateAnswers(answers : List<Answer>){
        this.answers = answers
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class ViewHolder(element: View) : RecyclerView.ViewHolder(element){
        val textAnswer = itemView.findViewById<TextView>(R.id.fullText_answer)
        val score = itemView.findViewById<TextView>(R.id.score_number)
        val nameUser = itemView.findViewById<TextView>(R.id.nameUser_answer)
        val dateAnswer = itemView.findViewById<TextView>(R.id.date_answer)

        fun Combine(item : Answer){
            textAnswer.text = item.
        }
    }
}