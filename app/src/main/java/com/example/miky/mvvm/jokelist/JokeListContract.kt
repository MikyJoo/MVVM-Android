package com.example.miky.mvvm.jokelist

import androidx.lifecycle.MutableLiveData
import com.example.miky.mvvm.data.Joke
import java.text.FieldPosition

interface JokeListContract {

    companion object Build {
        fun build(view: View) {
            var coordinator = JokeListCoordinator()
            var viewModel = JokeListViewModel(coordinator)
            view.viewModel = viewModel
        }
    }

    interface Coordinator {
        fun presentJokeDetail(view: View, joke: Joke)
    }

    interface View {
        var viewModel: ViewModel
    }

    interface ViewModel {
        var liveJokeList: MutableLiveData<ArrayList<Joke>>

        fun onCreate()
        fun refresh()
        fun onClickJokeListItem(view: View, position: Int)
//        fun swapItem(oldPosition: Int, newPosition: Int)
//        fun removeItem(position: Int)
    }
}
