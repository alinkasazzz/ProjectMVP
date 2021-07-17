package com.example.projectmvp.ui.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.projectmvp.R
import com.example.projectmvp.databinding.FragmentUsersBinding
import com.example.projectmvp.mvp.model.repo.GitUsersRepo
import com.example.projectmvp.mvp.presenter.UsersPresenter
import com.example.projectmvp.mvp.view.UsersView
import com.example.projectmvp.ui.App
import com.example.projectmvp.ui.BackBtnListener
import com.example.projectmvp.ui.adapter.UsersRVAdapter
import com.example.projectmvp.ui.navigations.AndroidScreens
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(R.layout.fragment_users), UsersView, BackBtnListener {
    companion object {
        fun getInstance() = UsersFragment()
    }

    private val binding: FragmentUsersBinding by viewBinding()
    private val presenter by moxyPresenter {
        UsersPresenter(
            GitUsersRepo(),
            App.instance.router,
            AndroidScreens(),
            AndroidSchedulers.mainThread()
        )
    }
    private var adapter: UsersRVAdapter? = null

    override fun init() {
        binding.usersList.layoutManager = LinearLayoutManager(requireActivity())
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        binding.usersList.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backClick()
}