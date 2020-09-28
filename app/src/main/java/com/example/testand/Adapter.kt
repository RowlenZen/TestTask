package com.example.testand

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*


class Adapter(val clickListener: (Item) -> Unit ) : RecyclerView.Adapter<Adapter.ViewHolder>() {


    var items: List<Item> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_answer, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.combineItems(items[position],clickListener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateList(items : List<Item>){
        this.items = items
        notifyDataSetChanged()
    }

    class ViewHolder(element: View) : RecyclerView.ViewHolder(element) {

        val textHead = itemView.findViewById(R.id.text_head) as TextView
        val date = itemView.findViewById(R.id.text_date) as TextView
        val totalAnswer = itemView.findViewById(R.id.text_answer) as TextView
        val image = itemView.findViewById(R.id.image_user) as ImageView
        val nickname = itemView.findViewById(R.id.text_name) as TextView
        val dateToNormal : SimpleDateFormat = SimpleDateFormat("dd.MM.yyyy")

        fun combineItems(item : Item, clickListener: (Item) -> Unit) {
            val dateEdit : Date = Date(item.creationDate*1000)
            textHead.text = item.title
            date.text = dateToNormal.format(dateEdit)
            totalAnswer.text = item.answerCount.toString()
            nickname.text = item.owner.displayName

            Glide
                .with(image)
                .load(item.owner.profileImage)
                .into(image)


            itemView.setOnClickListener {
                clickListener(item)
            }
        }
    }
}
