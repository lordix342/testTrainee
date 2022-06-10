package com.pride.testtrainee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.pride.testtrainee.ViewModel.ViewModelBinding
import com.pride.testtrainee.databinding.FragmentSelectGifBinding

class SelectGif : Fragment() {
    private lateinit var binding: FragmentSelectGifBinding
    private val viewM: ViewModelBinding by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectGifBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewM.gifSelect.observe(viewLifecycleOwner) {
            if (it != null) {
                Glide.with(binding.root).asGif().load(it.images.downsized.url)
                    .into(binding.imageView2)
            }
        }
    }
}