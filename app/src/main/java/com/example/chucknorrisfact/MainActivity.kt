package com.example.chucknorrisfact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
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
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration


private val TAG = "D Jokes"

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    //TO resolve Smart casting error we use a local variable with smart cast
    private lateinit var viewManager: RecyclerView.LayoutManager
    private val compositeDisp: CompositeDisposable= CompositeDisposable()
    private lateinit var loader: ProgressBar
    private lateinit var secondaryAdapter: JokeAdapter
    private lateinit var savedJokes :List<Joke>
    private var countJ:Int=1
   


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)






        viewManager = LinearLayoutManager(this)
        val viewAdapter = JokeAdapter()
        //viewAdapter.jokelist = savedJokes
        secondaryAdapter=viewAdapter


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
                    viewAdapter.jokelist = viewAdapter.jokelist.plus(it);
                    savedJokes = viewAdapter.jokelist;
                    loader.setVisibility(View.VISIBLE);


                },
                onComplete = {  countJ++; loader.setVisibility(View.INVISIBLE);}

            )
        }

        if (secondaryAdapter.jokelist.isEmpty()) {
            Log.d("BOOL","Reload Jokes")
            printJokes()
        }

        viewAdapter.setOnBottomReachedListener2(object: OnBottomReachedListener {
            override fun onBottomReached(position: Int) {
                if (!compositeDisp.isDisposed())
                    compositeDisp.clear()

                printJokes()
            }
        });




    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        var str=""
        var compteur: Int =0
        outState.putInt("nbJokes",savedJokes.size)
        for (k in savedJokes.indices) {

            str = compteur.toString()


            outState.putString(
                str,
                Json(JsonConfiguration.Stable).stringify(Joke.serializer(), savedJokes[compteur])
            )

            Log.d("Valeur du compteur", compteur.toString())
            compteur++
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        var str=""
        val cnt=savedInstanceState.getInt("nbJokes")
        ///
        var transitJokeList = emptyList<Joke>()
        var compteur=0
        for (k in 0..cnt-1) {
            str = compteur.toString()
            Log.d("Valeur du compteur 2", compteur.toString())
            transitJokeList = transitJokeList.plus(
                Json(JsonConfiguration.Stable).parse(
                    Joke.serializer(),
                    savedInstanceState.getString(str)!!
                )
            )
            compteur++

        }
        secondaryAdapter.jokelist = secondaryAdapter.jokelist.plus(transitJokeList)

    }
}
