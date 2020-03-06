package com.example.miky.mvvm.detail

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.miky.mvvm.data.Joke
import com.example.miky.mvvm.jokelist.JokeListCoordinator
import com.example.miky.mvvm.jokelist.JokeListViewModel

interface JokeDetailContract {
    companion object Build {
        fun build(view: View) {
            var coordinator = JokeDetailCoordinator()
            var viewModel = JokeDetailViewModel(coordinator)
            view.viewModel = viewModel
        }
    }

    interface Coordinator {

    }

    interface View {
        var viewModel: ViewModel
    }

    interface ViewModel {
        var jokeLiveData: MutableLiveData<Joke>

        fun onCreate(intent: Intent)
//        fun setIndex(index: Int)
//        fun refreshTest()
    }
}
