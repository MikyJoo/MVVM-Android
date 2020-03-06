package com.example.miky.mvvm.detail

import android.content.Intent
import androidx.lifecycle.MutableLiveData
import com.example.miky.mvvm.data.Joke

interface JokeDetailContract {

    interface DI {
        fun build(view: View)
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
