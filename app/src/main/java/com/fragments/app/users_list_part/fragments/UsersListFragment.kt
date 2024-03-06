package com.fragments.app.users_list_part.fragments

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import com.fragments.app.databinding.FragmentUsersListBinding
import com.fragments.app.users_list_part.ContactsViewModel
import com.fragments.app.users_list_part.Extensions.getParcelableCompat
import com.fragments.app.users_list_part.User
import com.fragments.app.users_list_part.UsersAdapter

class UsersListFragment : Fragment() {

    private lateinit var binding: FragmentUsersListBinding
    private val contactsViewModel: ContactsViewModel by lazy {
        ViewModelProvider(this)[ContactsViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsersListBinding.inflate(layoutInflater)
        initView()
        setFragmentResultListener(REQUEST_KEY) { _, bundle ->
            val position = bundle.getInt(POSITION_KEY)
            val user = bundle.getParcelableCompat(BUNDLE_USER_KEY, User::class.java)
            contactsViewModel.usersList[position] = user
            binding.userRecyclerView.adapter?.notifyItemChanged(position)
        }
        return binding.root
    }

    private fun initView() {
        val adapter = UsersAdapter(contactsViewModel.usersList, this)
        binding.userRecyclerView.adapter = adapter
    }

}