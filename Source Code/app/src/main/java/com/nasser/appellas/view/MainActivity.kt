package com.nasser.appellas.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.nasser.appellas.AppApplication
import com.nasser.appellas.R
import com.nasser.appellas.databinding.ActivityMainBinding
import com.nasser.appellas.viewmodels.AppViewModel
import com.nasser.appellas.viewmodels.AppViewModelFactory

class MainActivity : AppCompatActivity() {

    private val userApp by lazy {
        application as AppApplication
    }

    private val appViewModel: AppViewModel by viewModels {
        AppViewModelFactory(userApp.appRepository)
    }

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            viewmodel = appViewModel
            lifecycleOwner = this@MainActivity
        }
    }
}