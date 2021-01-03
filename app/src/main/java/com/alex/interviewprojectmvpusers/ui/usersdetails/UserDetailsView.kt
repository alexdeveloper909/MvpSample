package com.alex.interviewprojectmvpusers.ui.usersdetails

import com.alex.interviewprojectmvpusers.framework.db.domain.User
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.AddToEndSingleTagStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.SingleState

interface UserDetailsView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showData(user: User)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setVisible()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setNotVisible()
}