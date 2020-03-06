package com.example.miky.mvvm.detail

class JokeDetailDI: JokeDetailContract {

    companion object: JokeDetailContract.DI {
        override fun build(view: JokeDetailContract.View) {
            var coordinator = JokeDetailCoordinator()
            var viewModel = JokeDetailViewModel(coordinator)
            view.viewModel = viewModel
        }
    }
}