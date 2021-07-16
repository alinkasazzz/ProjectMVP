package com.example.projectmvp.mvp.presenter.list

import com.example.projectmvp.mvp.view.list.IItemView
import com.example.projectmvp.mvp.view.list.UserItemView

interface IUserListPresenter : IListPresenter<UserItemView>

interface IListPresenter<V> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}