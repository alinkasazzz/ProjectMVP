package com.example.projectmvp.mvp.model.repo

import com.example.projectmvp.mvp.model.entity.GitUser
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers


class GitUsersRepo {
    private val users = listOf(
        GitUser("Александр", "alex007"),
        GitUser("Пётр", "euro2021"),
        GitUser("Ирина", "columbiaASS"),
        GitUser("Олег", "o0o0o0leg"),
        GitUser("Алина", "k.i.s.a"),
        GitUser("Надежда", "iNadya")
    )

    fun getUsers(): Single<List<GitUser>> = Single.fromCallable {
        users
    }.subscribeOn(Schedulers.io())
}