package com.pride.testtrainee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pride.testtrainee.databinding.FragmentGifListBinding


class GifList : Fragment(), ClickListener {
private lateinit var binding : FragmentGifListBinding
    private var adapter = ListAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGifListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listText = arrayListOf("text1","text2","text3","text1","text2","text3","text1","text2","text3","text1","text2","text3")
        adapter.setData(listText)
        binding.rcView.adapter = adapter
        binding.rcView.layoutManager = GridLayoutManager(
            requireContext(), 3
        )
    }

    override fun onClick(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }
}