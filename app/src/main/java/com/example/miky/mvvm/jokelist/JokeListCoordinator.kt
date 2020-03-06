package com.example.miky.mvvm.jokelist

import android.content.Context
import android.content.Intent
import com.example.miky.mvvm.data.Joke
import com.example.miky.mvvm.detail.JokeDetailActivity

class JokeListCoordinator: JokeListContract.Coordinator {

    override fun presentJokeDetail(view: JokeListContract.View, joke: Joke) {
        var context = view as Context
        var intent = Intent(context, JokeDetailActivity::class.java)
        intent.putExtra("joke", joke)
        context.startActivity(intent)
    }
}