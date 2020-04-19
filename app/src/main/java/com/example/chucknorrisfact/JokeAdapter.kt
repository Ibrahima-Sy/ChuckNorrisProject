package com.example.chucknorrisfact
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter



class JokeAdapter(): Adapter <JokeAdapter.JokeViewHolder>() {

    class JokeViewHolder(val Joke: TextView): RecyclerView.ViewHolder(Joke)

    var jokelist = emptyList<Joke>()
        set(value) {
            notifyDataSetChanged()
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val Joke= LayoutInflater.from(parent.context)
            .inflate(R.layout.joke_layout,parent,false) as TextView
        return JokeViewHolder(Joke)
    }

    override fun getItemCount(): Int {
        val count= jokelist.size
        return count

    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
     //Set the new data you want to display by replacing old data with new one
        holder.Joke.text=jokelist[position].value

    }

}