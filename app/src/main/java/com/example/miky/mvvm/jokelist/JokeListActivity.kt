package com.example.miky.mvvm.jokelist

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miky.mvvm.R
import com.example.miky.mvvm.databinding.ActivityJokeListBinding

class JokeListActivity : AppCompatActivity(), JokeListContract.View {

    override lateinit var viewModel: JokeListContract.ViewModel
    private lateinit var binding: ActivityJokeListBinding

    private var layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    private lateinit var adapter: JokeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JokeListContract.build(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_joke_list)

        binding.mainSl.setOnRefreshListener {
            viewModel.refresh()
        }
        binding.mainSl.isRefreshing = true

        binding.jokeList.layoutManager = layoutManager
        adapter = JokeListAdapter(this, null, onClickListItem)
        binding.jokeList.adapter = adapter
        itemTouchHelper.attachToRecyclerView(binding.jokeList)

        viewModel.liveJokeList.observe(this, Observer {
            Log.i("miky", "observe~!!!! ${it.size}")
            binding.mainSl.isRefreshing = false
            adapter.setList(it)
        })

        viewModel.onCreate()
    }

    val onClickListItem = fun(view: View, position: Int) {
        viewModel.onClickJokeListItem(this, position)
    }

    var itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
        ItemTouchHelper.UP or ItemTouchHelper.DOWN, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            Log.i("miky", "old:${viewHolder.adapterPosition}   new: ${target.adapterPosition}")
            var oldPosition = viewHolder.adapterPosition
            var newPosition = target.adapterPosition
            return adapter.changeItemPosition(oldPosition, newPosition)
        }

        override fun onSwiped(
            viewHolder: RecyclerView.ViewHolder,
            direction: Int
        ) {
            var position = viewHolder.adapterPosition
            adapter.removeItem(position)
        }
    })
}
