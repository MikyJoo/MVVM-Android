package com.example.miky.mvvm.jokelist

class JokeListDI : JokeListContract {

    companion object: JokeListContract.DI {
        override fun build(view: JokeListContract.View) {
            var coordinator = JokeListCoordinator()
            var viewModel = JokeListViewModel(coordinator)
            view.viewModel = viewModel
        }
    }

}