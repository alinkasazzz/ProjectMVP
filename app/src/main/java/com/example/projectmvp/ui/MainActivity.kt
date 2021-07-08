package com.example.projectmvp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.projectmvp.R
import com.example.projectmvp.databinding.ActivityMainBinding
import com.example.projectmvp.mvp.presenter.MainPresenter
import com.example.projectmvp.mvp.view.MainView

class MainActivity : AppCompatActivity(R.layout.activity_main), MainView {
    private val binding: ActivityMainBinding by viewBinding()
    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setListeners()
    }

    override fun setDisplayText(index: Int,text: String) {
        when(index){
            1 -> binding.display1.text = text
            2 -> binding.display2.text = text
            3 -> binding.display3.text = text
        }
    }

    private fun setListeners() {
        binding.button1.setOnClickListener {
            presenter.btn1Click()
        }
        binding.button2.setOnClickListener {
            presenter.btn2Click()
        }
        binding.button3.setOnClickListener {
            presenter.btn3Click()
        }
    }
}