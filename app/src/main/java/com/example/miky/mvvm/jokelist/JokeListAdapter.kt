package com.example.miky.mvvm.jokelist

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.miky.mvvm.R
import com.example.miky.mvvm.data.Joke
import com.example.miky.mvvm.databinding.JokeListItemBinding
import java.util.*
import kotlin.collections.ArrayList

class JokeListAdapter(
    private var context: Context,
    private var jokeList: ArrayList<Joke>?,
    var itemClickListener: (View, Int) -> Unit): RecyclerView.Adapter<JokeListAdapter.JokeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        var binding = DataBindingUtil.inflate<JokeListItemBinding>(LayoutInflater.from(context), R.layout.joke_list_item, parent, false)
        return JokeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return jokeList?.size ?: 0
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.bind(position)
    }

    fun setList(list: ArrayList<Joke>) {
        jokeList = list
        notifyDataSetChanged()
    }

    inner class JokeViewHolder(var binding: JokeListItemBinding): ViewHolder(binding.root) {

        fun bind(position: Int) {
            jokeList?.let {
                var joke = it[position]
                binding.positionText.text = position.toString()
                binding.idText.text = joke.id.toString()
                binding.jokeText.text = joke.joke
                binding.root.setOnClickListener {
                    itemClickListener(it, adapterPosition)
                }
            }
        }
    }

    fun changeItemPosition(oldPosition: Int, newPosition: Int): Boolean {
        jokeList?.let {
            Collections.swap(it, oldPosition, newPosition)
            notifyItemMoved(oldPosition, newPosition)
            return true
        }
        return false
    }

    fun removeItem(position: Int) {
        jokeList?.let {
            it.removeAt(position)
            notifyItemRemoved(position)
        }
    }
}