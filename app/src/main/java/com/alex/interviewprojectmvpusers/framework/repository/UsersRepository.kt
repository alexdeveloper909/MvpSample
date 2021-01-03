package com.alex.interviewprojectmvpusers.framework.repository

import androidx.lifecycle.MutableLiveData

object UsersRepository {

    private var idChangeCallback:IdChangeCallback?=null

    fun subscribeCallback(idChangeCallback: IdChangeCallback){
        this.idChangeCallback = idChangeCallback
    }

    fun unsubscribeCallback(){
        this.idChangeCallback = null
    }

    fun setId(str:String){
        idChangeCallback?.onIdChanged(str)
    }

}
