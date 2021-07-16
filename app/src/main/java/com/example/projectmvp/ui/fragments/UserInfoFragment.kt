package com.example.projectmvp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.projectmvp.R
import com.example.projectmvp.databinding.FragmentUserInfoBinding
import com.example.projectmvp.mvp.model.entity.GitUser
import com.example.projectmvp.mvp.presenter.UserInfoPresenter
import com.example.projectmvp.mvp.view.UserInfoView
import com.example.projectmvp.ui.App
import com.example.projectmvp.ui.BackBtnListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserInfoFragment : MvpAppCompatFragment(R.layout.fragment_user_info), UserInfoView,
    BackBtnListener {
    companion object {
        private const val TAG = "user"
        fun newInstance(user: GitUser) = UserInfoFragment().apply {
            arguments = Bundle().apply {
                putParcelable(TAG, user)
            }
        }
    }

    private val binding: FragmentUserInfoBinding by viewBinding()
    private val presenter: UserInfoPresenter by moxyPresenter {
        val user = arguments?.getParcelable<GitUser>(TAG) as GitUser
        UserInfoPresenter(App.instance.router, user)
    }

    override fun displayInfo(login: String) {
        binding.name.text = login
    }

    override fun backPressed() = presenter.backClick()


}