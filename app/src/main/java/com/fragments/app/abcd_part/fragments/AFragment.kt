package com.fragments.app.abcd_part.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fragments.app.abcd_part.ABCDActivity
import com.fragments.app.databinding.FragmentABinding

class AFragment : Fragment() {

    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentABinding.inflate(layoutInflater)
        initView()
        return binding.root
    }

    private fun initView() {
        binding.moveToBButton.setOnClickListener {
            (requireActivity() as ABCDActivity).goToNextFragment("bFragment", BFragment())
        }
    }
}