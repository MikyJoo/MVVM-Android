package com.example.miky.mvvm.detail

import android.content.Intent
import androidx.lifecycle.MutableLiveData
import com.example.miky.mvvm.data.Joke

class JokeDetailViewModel(var coordinator: JokeDetailContract.Coordinator): JokeDetailContract.ViewModel {

//    var repository = JokeRepository.getInstance()
    override var jokeLiveData = MutableLiveData<Joke>()

    override fun onCreate(intent: Intent) {
        var joke = intent.getParcelableExtra<Joke>("joke")

        joke?.let {
            jokeLiveData.postValue(joke)
        }
    }

//    override fun setIndex(index: Int) {
//        liveJokeItem = Transformations.map(repository.jokeList) {
//            it[index]
//        }
//    }
//
//    override fun refreshTest() {
//        repository.requestList()
//    }
}