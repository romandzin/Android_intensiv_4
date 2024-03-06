package com.fragments.app.abcd_part.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
import com.fragments.app.R
import com.fragments.app.abcd_part.ABCDActivity
import com.fragments.app.databinding.FragmentCBinding

const val C_FRAGMENT_KEY = "key"

class CFragment : Fragment() {

    private lateinit var binding: FragmentCBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCBinding.inflate(layoutInflater)
        initView()
        return binding.root
    }

    private fun initView() {
        val bundleData = getBundleData()
        if (bundleData != null) binding.dataTextView.text = bundleData
        binding.moveToDButton.setOnClickListener {
            (requireActivity() as ABCDActivity).goToNextFragment("dFragment", DFragment())
        }
        binding.moveToAButton.setOnClickListener {
            val fragmentManager = (requireActivity() as ABCDActivity).supportFragmentManager
            fragmentManager.popBackStack("bFragment", POP_BACK_STACK_INCLUSIVE)
        }
    }

    private fun getBundleData(): String? {
        val bundle = this.arguments
        if (bundle != null) {
            return bundle.getString(C_FRAGMENT_KEY, null)
        }
        return null
    }

    companion object {

        fun newInstance(dataString: String): CFragment {
            return CFragment().apply {
                arguments = Bundle().also { it.putString(C_FRAGMENT_KEY, dataString) }
            }
        }
    }

}