package com.fragments.app.abcd_part.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fragments.app.abcd_part.ABCDActivity
import com.fragments.app.databinding.FragmentBBinding

class BFragment : Fragment() {

    private lateinit var binding: FragmentBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBBinding.inflate(layoutInflater)
        initView()
        return binding.root
    }

    private fun initView() {
        binding.moveToCButton.setOnClickListener {
            val cFragment = getCFragment()
            (requireActivity() as ABCDActivity).goToNextFragment("cFragment", cFragment)
        }
        binding.moveBack.setOnClickListener {
            (requireActivity() as ABCDActivity).onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun getCFragment(): CFragment {
        return CFragment.newInstance("Hello world")
    }
}