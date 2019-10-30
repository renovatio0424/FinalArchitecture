package com.charlezz.finalarchitecture.feature

import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

@Suppress("UNCHECKED_CAST")
@BindingAdapter("bind:list")
fun <T> submitList(recyclerView: androidx.recyclerview.widget.RecyclerView, pageList: PagedList<T>?) {
    pageList?.let {
        val adapter = recyclerView.adapter as PagedListAdapter<T, *>
        adapter.submitList(pageList)
    }
}

@BindingAdapter("bind:isVisible")
fun setVisibility(view: View, isVisible: Boolean){
    if(isVisible){
        view.visibility = View.VISIBLE
    }else{
        view.visibility = View.GONE
    }
}

@BindingAdapter("bind:image")
fun setImage(imageView: ImageView, path:String?){
    path?.let {
        Glide.with(imageView).load(it).transition(DrawableTransitionOptions.withCrossFade()).into(imageView)
    }
}