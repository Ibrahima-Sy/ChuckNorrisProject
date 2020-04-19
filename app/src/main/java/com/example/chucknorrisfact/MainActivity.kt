package com.example.chucknorrisfact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ProgressBar;


private val TAG = "D Jokes"

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    //TO resolve Smart casting error we use a local variable with smart cast
    private lateinit var viewManager: RecyclerView.LayoutManager
    private val compositeDisp: CompositeDisposable= CompositeDisposable()
    private lateinit var loader: ProgressBar

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



        loader= findViewById(R.id.loader_id)

        fun printJokes(){
            val thaJokes = jokeServiceF.idle1().giveMe10().repeat(10).subscribeOn(Schedulers.io())
                .doOnSubscribe {
                    loader.setVisibility(
                        View.VISIBLE
                    );compositeDisp.add(it)
                }.observeOn(AndroidSchedulers.mainThread()).subscribeBy(
                onNext = {
                    loader.setVisibility(View.INVISIBLE);
                    viewAdapter.jokelist = viewAdapter.jokelist.plus(it)
                    loader.setVisibility(View.VISIBLE);


                },
                onComplete = { loader.setVisibility(View.INVISIBLE); }

            )
        }

        printJokes()

        viewAdapter.setOnBottomReachedListener2(object: OnBottomReachedListener {
            override fun onBottomReached(position: Int) {
                if (!compositeDisp.isDisposed())
                    compositeDisp.clear()

                printJokes()
            }
        });


        //We only need to clear the resource if the disposable has NOT been disposed

    }
}
