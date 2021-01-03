package com.alex.interviewprojectmvpusers.ui.userslist

import com.alex.interviewprojectmvpusers.framework.db.daos.UserDao
import com.alex.interviewprojectmvpusers.framework.db.domain.User
import com.alex.interviewprojectmvpusers.framework.network.Status
import com.alex.interviewprojectmvpusers.framework.repository.ApiRepository
import com.alex.interviewprojectmvpusers.framework.repository.UsersRepository
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class UsersListPresenter @Inject constructor(
        private val usersRepository: UsersRepository,
        private val apiRepository: ApiRepository,
        private val userDao: UserDao
) : MvpPresenter<UsersListView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        presenterScope.launch {
            val list = userDao.getAllUsers()
            if(list.isNotEmpty()) {
                viewState.addAllUsers(list)
            }
        }
    }


    fun onFabClicked(){
        presenterScope.launch {

            viewState.showProgressBar()
            val i = apiRepository.fetchUserData()
            when (i.status) {
                Status.ERROR -> {
                    viewState.hideProgressBar()
                    viewState.showToast(i.message!!)
                }
                Status.SUCCESS -> {
                    viewState.hideProgressBar()
                    with(i.data!!.results.first()) {
                        val user = User(
                            this.login.uuid,
                            this.name.first,
                            this.name.last,
                            "${this.location.street.name}, ${this.location.city}",
                            this.registered.date,
                            this.email,
                            this.cell,
                            this.picture.medium
                        )
                        userDao.addUser(user)
                        viewState.addAllUsers(userDao.getAllUsers())
                    }
                }
            }
        }
    }

    fun onUserSelected(id:String){
        usersRepository.setId(id)
    }



}