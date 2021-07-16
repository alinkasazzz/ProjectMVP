package com.example.projectmvp.mvp.presenter

import com.example.projectmvp.mvp.model.entity.GitUser
import com.example.projectmvp.mvp.view.UserInfoView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserInfoPresenter(private val router: Router, private val user: GitUser) :
    MvpPresenter<UserInfoView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.displayInfo(user.login)
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}