package com.example.projectmvp.mvp.presenter

import com.example.projectmvp.mvp.model.CountersModel
import com.example.projectmvp.mvp.view.MainView

class MainPresenter(private val view: MainView) {
    private val model = CountersModel()

    fun btn1Click(){
        val nextValue = model.next(0)
        view.setDisplayText(1,nextValue.toString())
    }

    fun btn2Click(){
        val nextValue = model.next(1)
        view.setDisplayText(2,nextValue.toString())
    }

    fun btn3Click(){
        val nextValue = model.next(2)
        view.setDisplayText(3,nextValue.toString())
    }
}