package com.example.projectmvp.mvp.model.repo

import com.example.projectmvp.mvp.model.entity.GitUser

class GitUsersRepo {
    private val users = listOf(
        GitUser("Александр", "alex007"),
        GitUser("Пётр", "euro2021"),
        GitUser("Ирина", "columbiaASS"),
        GitUser("Олег", "o0o0o0leg"),
        GitUser("Алина", "k.i.s.a"),
        GitUser("Надежда", "iNadya")
    )

    fun getUsers(): List<GitUser> {
        return users
    }
}