package com.example.projectmvp.mvp.presenter

import com.example.projectmvp.mvp.model.entity.GitUser
import com.example.projectmvp.mvp.model.repo.GitUsersRepo
import com.example.projectmvp.mvp.navigation.IScreens
import com.example.projectmvp.mvp.presenter.list.IUserListPresenter
import com.example.projectmvp.mvp.view.UsersView
import com.example.projectmvp.mvp.view.list.UserItemView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter

class UsersPresenter(
    private val usersRepo: GitUsersRepo,
    private val router: Router,
    private val screens: IScreens,
    private val uiScheduler: Scheduler,
) : BaseMvpPresenter<UsersView>() {
    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GitUser>()

        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.name)
        }

        override fun getCount() = users.size
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        setItemClickListener()
    }

    private fun loadData() {
        usersRepo.getUsers()
            .observeOn(uiScheduler)
            .subscribe({ users ->
                usersListPresenter.users.addAll(users)
                viewState.updateList()
            }, {
                it.printStackTrace()
            }).disposeOnDestroy()
    }

    private fun setItemClickListener() {
        usersListPresenter.itemClickListener = {
            router.navigateTo(screens.user(usersListPresenter.users[it.pos]))
        }
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}