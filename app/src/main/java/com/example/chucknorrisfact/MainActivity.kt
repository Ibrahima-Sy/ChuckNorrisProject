package com.example.chucknorrisfact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


private val TAG = "D Jokes"

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    //TO resolve Smart casting error we use a local variable with smart cast
    private lateinit var viewManager: RecyclerView.LayoutManager
    private val compositeDisp: CompositeDisposable= CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        viewManager = LinearLayoutManager(this)
        var viewAdapter = JokeAdapter()

        recyclerView = findViewById<RecyclerView>(R.id.recylerview_id).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }





        val jokeServiceF = JokeApiServiceFactory

        val thaJoke = jokeServiceF.idle1().giveMeAJoke().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeBy (
            onError= { Log.d("ERROR","empty")},
            onSuccess={ viewAdapter.jokelist = viewAdapter.jokelist.plus(it)
            }

        )

        bouton.setOnClickListener {

            val thaOtherJoke = jokeServiceF.idle1().giveMeAJoke().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeBy (
                onError= { Log.d("ERROR","empty")},
                onSuccess={ viewAdapter.jokelist = viewAdapter.jokelist.plus(it)
                }

            )
        }

        compositeDisp.add(thaJoke)

        //We only need to clear the resource if the disposable has NOT been disposed
        if (compositeDisp.isDisposed())
            compositeDisp.clear()
    }
}
