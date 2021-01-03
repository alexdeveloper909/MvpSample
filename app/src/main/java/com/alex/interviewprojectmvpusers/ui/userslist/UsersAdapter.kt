package com.alex.interviewprojectmvpusers.ui.userslist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alex.interviewprojectmvpusers.R
import com.alex.interviewprojectmvpusers.framework.db.domain.User

class UsersAdapter(val event: MutableLiveData<UserItemEvent> = MutableLiveData()) : ListAdapter<User, UsersAdapter.NoteViewHolder>(ContestsDiffUtilCallBack()) {


    class NoteViewHolder(root: View): RecyclerView.ViewHolder(root){
        val textView = root.findViewById(R.id.textView) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NoteViewHolder(
                inflater.inflate(R.layout.city_row, parent,false)
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        getItem(position).let {note ->
            holder.textView.text = "${note.firstName} ${note.secondName}"
            holder.itemView.setOnClickListener {
                event.postValue(UserItemEvent.OnNoteClick(note.id))
            }
        }
    }
}
 class ContestsDiffUtilCallBack : DiffUtil.ItemCallback<User>(){
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }


}