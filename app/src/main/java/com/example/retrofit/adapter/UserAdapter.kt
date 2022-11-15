package com.example.retrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.retrofit.databinding.ItemLayoutBinding
import com.example.retrofit.model.User

class UserAdapter: ListAdapter<User, UserAdapter.UserViewHolder>(DiffCallback()) {

    private class DiffCallback: DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.find(getItem(position))
    }

    inner class UserViewHolder(private val binding: ItemLayoutBinding):
            RecyclerView.ViewHolder(binding.root){
                fun find(user: User){
                    binding.apply {
                        Glide.with(imageView)
                            .load(user.avatar_url)
                            .transition(DrawableTransitionOptions.withCrossFade(1000))
                            .into(imageView)
                    }
                    binding.textView.text = user.login
                }
            }

}