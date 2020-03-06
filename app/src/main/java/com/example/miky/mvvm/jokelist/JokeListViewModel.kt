package com.example.miky.mvvm.jokelist

import android.util.Log
import com.example.miky.mvvm.data.JokeRepository
import java.util.*

class JokeListViewModel(var coordinator: JokeListContract.Coordinator): JokeListContract.ViewModel {

    var repository = JokeRepository.getInstance()

    override var liveJokeList = repository.getLiveDataForList()

    override fun onCreate() {
    }

    override fun refresh() {
        repository.requestList()
    }

    override fun onClickJokeListItem(view: JokeListContract.View, position: Int) {

        Log.i("miky","onclick joke position: $position")
        Log.i("miky","onclick joke size: ${liveJokeList.value!!.size}")

        val joke = liveJokeList.value!![position]
        coordinator.presentJokeDetail(view, joke)
    }

//    override fun swapItem(oldPosition: Int, newPosition: Int) {
//        liveJokeList.value?.let {
////            Collections.swap(it, oldPosition, newPosition)
////            liveJokeList.value = it
//        }
//    }

//    override fun removeItem(position: Int) {
//        Log.i("miky","remove Item: $position")
//        liveJokeList.value?.let {
//            it.removeAt(position)
//        }
//    }
}