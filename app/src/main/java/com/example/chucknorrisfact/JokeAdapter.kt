package com.example.chucknorrisfact
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

// Solution inspired from https://medium.com/@ayhamorfali/android-detect-when-the-recyclerview-reaches-the-bottom-43f810430e1e
interface OnBottomReachedListener {
    fun onBottomReached(position: Int)
}

class JokeAdapter(): Adapter <JokeAdapter.JokeViewHolder>() {

    var onBottomReachedListener: OnBottomReachedListener? = null

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

        if (position == jokelist.size - 1){

            onBottomReachedListener?.onBottomReached(position);

        }
        holder.Joke.text=jokelist[position].value

    }

    fun setOnBottomReachedListener2 (onBottomReachedListener: OnBottomReachedListener?) {
        this.onBottomReachedListener = onBottomReachedListener
    }

}