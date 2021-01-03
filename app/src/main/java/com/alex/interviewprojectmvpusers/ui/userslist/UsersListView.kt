package com.alex.interviewprojectmvpusers.ui.userslist

import android.support.v4.media.session.PlaybackStateCompat
import com.alex.interviewprojectmvpusers.framework.db.domain.User
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleTagStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEnd
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.SingleState
import moxy.viewstate.strategy.alias.Skip

interface UsersListView : MvpView {

    @Skip
    fun showProgressBar()

    @Skip
    fun hideProgressBar()

    @Skip
    fun showToast(message:String)

    @SingleState
    fun addAllUsers(users:List<User>)
}