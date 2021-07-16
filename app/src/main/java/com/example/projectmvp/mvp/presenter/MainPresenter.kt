package com.example.projectmvp.mvp.presenter

import com.example.projectmvp.mvp.navigation.IScreens
import com.example.projectmvp.mvp.view.MainView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(private val router: Router, private val screens: IScreens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClick(){
        router.exit()
    }
}