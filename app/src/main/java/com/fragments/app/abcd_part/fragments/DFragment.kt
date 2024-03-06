package com.fragments.app.abcd_part.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fragments.app.abcd_part.ABCDActivity
import com.fragments.app.databinding.FragmentDBinding

class DFragment : Fragment() {

    private lateinit var binding: FragmentDBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDBinding.inflate(layoutInflater)
        initView()
        return binding.root
    }

    private fun initView() {
        binding.moveToBButton.setOnClickListener {
                val fragmentManager = (requireActivity() as ABCDActivity).supportFragmentManager
                fragmentManager.popBackStack("bFragment", 0)
            }
    }
}