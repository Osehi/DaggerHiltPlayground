package com.polish.usedaggerhilt.ui.homepagefragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.polish.usedaggerhilt.data.localdatasource.PostCacheEntity
import com.polish.usedaggerhilt.databinding.IlistItemHomePageBinding

class HomePageAdapter(): ListAdapter<PostCacheEntity, HomePageAdapter.POSTViewHolder>(DiffCallback){

    class POSTViewHolder(var binding: IlistItemHomePageBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(postItem:PostCacheEntity){

            binding.postCacheEntity = postItem

            binding.executePendingBindings()

        }

    }

    companion object DiffCallback: DiffUtil.ItemCallback<PostCacheEntity>(){
        override fun areItemsTheSame(oldItem: PostCacheEntity, newItem: PostCacheEntity): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PostCacheEntity, newItem: PostCacheEntity): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): POSTViewHolder {
        return POSTViewHolder(IlistItemHomePageBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: POSTViewHolder, position: Int) {
        val post = getItem(position)


        holder.bind(post)

    }




}