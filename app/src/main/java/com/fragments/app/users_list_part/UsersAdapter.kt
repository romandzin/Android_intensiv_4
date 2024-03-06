package com.fragments.app.users_list_part

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fragments.app.R
import com.fragments.app.users_list_part.fragments.DetailsFragment
import com.fragments.app.users_list_part.fragments.UsersListFragment
import com.squareup.picasso.Picasso

class UsersAdapter(private val arrayList: ArrayList<User>, val fragment: UsersListFragment) :
    RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(arrayList[position])
        holder.itemView.setOnClickListener {
            val detailsFragment = getDetailsFragment(arrayList[position], position)
            val contactsActivity = (fragment.requireActivity() as ContactsActivity)
            contactsActivity.goToNextFragment("detailsFragment", detailsFragment)
        }
    }

    private fun getDetailsFragment(user: User, position: Int): DetailsFragment {
        return DetailsFragment.newInstance(user, position)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var userPhotoImageView: ImageView
        private var userNameTextView: TextView
        private var userSecondNameTextView: TextView
        private var userPhoneTextView: TextView

        init {
            userPhotoImageView = itemView.findViewById(R.id.userPhoto)
            userNameTextView = itemView.findViewById(R.id.name)
            userSecondNameTextView = itemView.findViewById(R.id.secondName)
            userPhoneTextView = itemView.findViewById(R.id.phoneNumber)
        }

        fun bind(user: User) {
            userNameTextView.text = user.name
            userSecondNameTextView.text = user.secondName
            userPhoneTextView.text = "+${user.phoneNumber}"
            val builder = Picasso.with(fragment.requireActivity())
            builder.isLoggingEnabled = true
            builder
                .load(user.photo)
                .into(userPhotoImageView)
        }
    }
}