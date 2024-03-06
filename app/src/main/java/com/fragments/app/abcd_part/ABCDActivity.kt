package com.fragments.app.abcd_part

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.fragments.app.databinding.ActivityAbcdactivityBinding

class ABCDActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAbcdactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbcdactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun goToNextFragment(tag: String, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment, tag)
            .addToBackStack(tag)
            .commit()
    }
}