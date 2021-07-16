package com.example.projectmvp.ui.activity

import com.example.projectmvp.R
import com.example.projectmvp.mvp.presenter.MainPresenter
import com.example.projectmvp.mvp.view.MainView
import com.example.projectmvp.ui.App
import com.example.projectmvp.ui.BackBtnListener
import com.example.projectmvp.ui.navigations.AndroidScreens
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(R.layout.activity_main), MainView {
    private val presenter by moxyPresenter { MainPresenter(App.instance.router, AndroidScreens()) }
    private val navigator = AppNavigator(this, R.id.fragment_container)

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach{
            if (it is BackBtnListener && it.backPressed()){
                return
            }
        }
        presenter.backClick()
    }
}