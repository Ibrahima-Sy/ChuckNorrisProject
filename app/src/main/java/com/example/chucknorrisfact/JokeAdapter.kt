package com.example.chucknorrisfact
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter


class JokeAdapter( pJokeList : List<String> = emptyList() ): Adapter <JokeAdapter.JokeViewHolder>() {

    class JokeViewHolder(val Joke: TextView): RecyclerView.ViewHolder(Joke)

    var jokeList = pJokeList
    set(value) {
        notifyDataSetChanged()
        field = value
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val jokeList= LayoutInflater.from(parent.context)
            .inflate(R.layout.joke_layout,parent,false) as TextView
        return JokeViewHolder(jokeList)
    }

    override fun getItemCount(): Int {
        val count= jokeList.size
        return (count)

    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
     //Set the new data you want to display by replacing old data with new one
        holder.Joke.text=jokeList[position]

    }

}