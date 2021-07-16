package com.example.projectmvp.mvp.navigation

import com.example.projectmvp.mvp.model.entity.GitUser
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun user(user: GitUser) : Screen
}