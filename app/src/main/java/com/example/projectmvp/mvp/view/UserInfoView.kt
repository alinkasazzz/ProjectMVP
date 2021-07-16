package com.example.projectmvp.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface UserInfoView: MvpView {
    fun displayInfo(login:String)
}