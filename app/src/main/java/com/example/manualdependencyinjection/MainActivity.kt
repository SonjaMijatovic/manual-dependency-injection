package com.example.manualdependencyinjection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.manualdependencyinjection.databinding.ActivityMainBinding
import com.example.manualdependencyinjection.di.MainContainer
import com.example.manualdependencyinjection.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val mainContainer =
            MainContainer((application as RandomApplication).applicationContainer.numberRepository)

        val viewModel = ViewModelProvider(
            this,
            mainContainer.getMainViewModelFactory()
        ).get(MainViewModel::class.java)

        viewModel.getLiveData().observe(this, Observer { number ->
            binding.content.activityMainTextView.text = number.toString()
        })

        binding.content.activityMainButton.setOnClickListener {
            viewModel.generateNextNumber()
        }
    }
}