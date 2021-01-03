package com.alex.interviewprojectmvpusers.ui.usersdetails

import com.alex.interviewprojectmvpusers.framework.db.daos.UserDao
import com.alex.interviewprojectmvpusers.framework.repository.ApiRepository
import com.alex.interviewprojectmvpusers.framework.repository.IdChangeCallback
import com.alex.interviewprojectmvpusers.framework.repository.UsersRepository
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class UserDetailsPresenter @Inject constructor(
    private val usersRepository: UsersRepository,
    private val apiRepository: ApiRepository,
    private val userDao: UserDao
) : MvpPresenter<UserDetailsView>() {

    private val onIdChangedCallback = object : IdChangeCallback{
        override fun onIdChanged(id: String) {
            presenterScope.launch {
                viewState.showData(userDao.getUserById(id))
                viewState.setVisible()
            }
        }
    }

    /*init {
        usersRepository.subscribeCallback(onIdChangedCallback)
    }*/

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setNotVisible()
        usersRepository.subscribeCallback(onIdChangedCallback)
    }

    override fun onDestroy() {
        super.onDestroy()
        usersRepository.unsubscribeCallback()
    }
}