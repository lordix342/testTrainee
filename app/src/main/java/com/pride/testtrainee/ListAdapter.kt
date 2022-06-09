package com.pride.testtrainee

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pride.testtrainee.databinding.GifForListBinding

class ListAdapter(private val clickListener: ClickListener) :
    RecyclerView.Adapter<ListAdapter.ListHolder>() {

    private var list = ArrayList<String>()

    class ListHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val binding = GifForListBinding.bind(itemView)
        fun bind(text: String, clickListener: ClickListener) = with(binding) {
            textView.text = text
            binding.card.setOnClickListener {
                clickListener.onClick(text)
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
        holder.bind(list[position], clickListener)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: ArrayList<String>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}