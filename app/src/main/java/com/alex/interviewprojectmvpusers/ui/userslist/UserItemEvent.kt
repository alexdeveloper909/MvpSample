package com.alex.interviewprojectmvpusers.ui.userslist

sealed class UserItemEvent{
    data class OnNoteClick(val id:String) : UserItemEvent()
}
