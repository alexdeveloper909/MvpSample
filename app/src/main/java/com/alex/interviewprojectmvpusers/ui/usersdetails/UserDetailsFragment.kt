package com.alex.interviewprojectmvpusers.ui.usersdetails

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alex.interviewprojectmvpusers.R
import com.alex.interviewprojectmvpusers.framework.db.domain.User
import com.alex.interviewprojectmvpusers.ui.userslist.UsersListPresenter
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_user_details.*
import moxy.MvpAppCompatFragment
import moxy.MvpFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider


@AndroidEntryPoint
class UserDetailsFragment : MvpAppCompatFragment(), UserDetailsView {


    @Inject
    lateinit var presenterProvider: Provider<UserDetailsPresenter>
    private val presenter: UserDetailsPresenter by moxyPresenter { presenterProvider.get() }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNotVisible()
    }

    @SuppressLint("SetTextI18n")
    override fun showData(user: User) {
        Glide.with(this).load(user.bigPhoto).into(profileImage);
        nameTextView.text = "${user.firstName} ${user.secondName}"
        addressTextView.text = user.address
        dateOfBirthTextView.text = user.birthDate
        emailTextView.text = user.email
        cellTextView.text = user.cell
    }

    override fun setVisible() {
        mainDetailsView.visibility = View.VISIBLE
    }

    override fun setNotVisible() {
        mainDetailsView.visibility = View.INVISIBLE
    }


}