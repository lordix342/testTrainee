package com.pride.testtrainee.ViewModel

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pride.testtrainee.Clases.Data
import com.pride.testtrainee.R
import com.pride.testtrainee.databinding.GifForListBinding

class ListAdapter(private val clickListener: ClickListener, private val context: Context) :
    RecyclerView.Adapter<ListAdapter.ListHolder>() {

    private var list = ArrayList<Data>()

    class ListHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val binding = GifForListBinding.bind(itemView)
        fun bind(gif: Data, clickListener: ClickListener, context: Context) = with(binding) {
            Glide.with(context).asGif().load(gif.images.downsized.url).into(binding.imageView)
            binding.card.setOnClickListener {
                clickListener.onClick(gif)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        return ListHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.gif_for_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.bind(list[position], clickListener, context)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: ArrayList<Data>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}