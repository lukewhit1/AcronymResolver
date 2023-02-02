package com.example.acronymresolver

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.acronymresolver.databinding.ActivityMainBinding
import com.example.acronymresolver.view.DashboardFragment
import com.example.acronymresolver.viewmodel.AcronymViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : AcronymViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[AcronymViewModel::class.java]
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(binding.mainFragment.id, DashboardFragment.newInstance())
            .commit()
    }
}

