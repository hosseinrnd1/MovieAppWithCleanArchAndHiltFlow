package com.example.moviesampleclean.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.moviesampleclean.R
import com.example.moviesampleclean.databinding.ActivityMainBinding
import com.example.moviesampleclean.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val navController= findNavController(R.id.fragmentContainer_Main)

        binding.bottomNavMain.setupWithNavController(navController);


    }
}