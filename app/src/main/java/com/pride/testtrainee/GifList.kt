package com.pride.testtrainee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.pride.testtrainee.Clases.Data
import com.pride.testtrainee.ViewModel.ClickListener
import com.pride.testtrainee.ViewModel.ListAdapter
import com.pride.testtrainee.ViewModel.ViewModelBinding
import com.pride.testtrainee.databinding.FragmentGifListBinding


class GifList : Fragment(), ClickListener {
    private lateinit var binding: FragmentGifListBinding
    private val viewM: ViewModelBinding by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGifListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ListAdapter(this, requireContext())
        viewM.getListFromRepo()
        viewM.gifList.observe(viewLifecycleOwner) {
            if (it != null) {
                adapter.setData(it)
            }
        }

        binding.rcView.adapter = adapter
        binding.rcView.layoutManager = GridLayoutManager(
            requireContext(), 3
        )
    }

    override fun onClick(gif: Data) {
        Navigation.findNavController(binding.root).navigate(R.id.action_gifList_to_selectGif)
        viewM.selectGif(gif)
    }
}