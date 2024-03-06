package com.fragments.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fragments.app.abcd_part.ABCDActivity
import com.fragments.app.databinding.ActivityMainBinding
import com.fragments.app.users_list_part.ContactsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

   private fun initView() {
       binding.abcdFragmentsButton.setOnClickListener {
           moveToActivity(ABCDActivity::class.java)
       }
       binding.usersFragmentsButton.setOnClickListener {
           moveToActivity(ContactsActivity::class.java)
       }
    }

    private fun <T> moveToActivity(activity: Class<T>) {
        val intent = Intent(this, activity)
        startActivity(intent)
    }
}