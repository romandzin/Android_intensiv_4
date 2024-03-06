package com.fragments.app.users_list_part.fragments

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.fragments.app.R
import com.fragments.app.abcd_part.fragments.CFragment
import com.fragments.app.abcd_part.fragments.C_FRAGMENT_KEY
import com.fragments.app.databinding.FragmentDetailsBinding
import com.fragments.app.users_list_part.ContactsActivity
import com.fragments.app.users_list_part.Extensions.getParcelableCompat
import com.fragments.app.users_list_part.User

const val DETAILS_KEY = "details_key"
const val POSITION_KEY = "position"
const val BUNDLE_USER_KEY = "bundleKey"
const val REQUEST_KEY = "requestKey"

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private var position = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        val bundleData = getBundleData()
        if (bundleData != null) setBundleData(bundleData)
        binding.finishButton.setOnClickListener {
            setFragmentResult(
                REQUEST_KEY,
                bundleOf(
                    BUNDLE_USER_KEY to User(
                        binding.photoUrl.text.toString(),
                        binding.name.text.toString(),
                        binding.secondName.text.toString(),
                        binding.phoneNumber.text.toString().toInt()
                    ),
                    POSITION_KEY to position
                )
            )
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        return binding.root
    }

    private fun setBundleData(user: User) {
        binding.photoUrl.setText(user.photo)
        binding.name.setText(user.name)
        binding.secondName.setText(user.secondName)
        binding.phoneNumber.setText(user.phoneNumber.toString())
    }

    private fun getBundleData(): User? {
        val bundle = this.arguments
        if (bundle != null) {
            position = bundle.getInt(POSITION_KEY)
            return bundle.getParcelableCompat(DETAILS_KEY, User::class.java)
        }
        return null
    }

    companion object {

        fun newInstance(userData: User, position: Int): DetailsFragment {
            return DetailsFragment().apply {
                arguments = Bundle().also { bundle ->
                    bundle.putParcelable(DETAILS_KEY, userData)
                    bundle.putInt(POSITION_KEY, position)
                }
            }
        }
    }

}