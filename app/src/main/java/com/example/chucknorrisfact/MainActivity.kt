package com.example.chucknorrisfact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisfact.JokeList.jokeList
import io.reactivex.Single
import io.reactivex.rxkotlin.subscribeBy


private val TAG = "D Jokes"

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jokeServiceF = JokeApiServiceFactory

        val thaJoke = jokeServiceF.Idle1().giveMeAJoke().subscribeBy(
            onError= { Log.d("ERROR",it.toString())},
            onSuccess={Log.d("SUCCESS",it.toString())}

        )


        viewManager = LinearLayoutManager(this)
        viewAdapter = JokeAdapter(jokeList)

        recyclerView = findViewById<RecyclerView>(R.id.recylerview_id).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        Log.d(TAG, jokeList.toString())
        }
    }
}
