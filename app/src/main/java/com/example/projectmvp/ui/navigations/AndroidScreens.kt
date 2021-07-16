package com.example.projectmvp.ui.navigations

import com.example.projectmvp.mvp.model.entity.GitUser
import com.example.projectmvp.mvp.navigation.IScreens
import com.example.projectmvp.ui.fragments.UserInfoFragment
import com.example.projectmvp.ui.fragments.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.getInstance() }
    override fun user(user: GitUser) = FragmentScreen { UserInfoFragment.newInstance(user) }
}