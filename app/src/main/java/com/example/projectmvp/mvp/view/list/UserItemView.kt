package com.example.projectmvp.mvp.view.list

interface UserItemView : IItemView {
    fun setLogin(text: String)
}

interface IItemView {
    var pos: Int
}

