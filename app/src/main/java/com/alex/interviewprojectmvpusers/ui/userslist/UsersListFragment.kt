package com.alex.interviewprojectmvpusers.ui.userslist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.alex.interviewprojectmvpusers.R
import com.alex.interviewprojectmvpusers.framework.db.domain.User
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_users_list.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider


@AndroidEntryPoint
class UsersListFragment : MvpAppCompatFragment(), UsersListView {

    private lateinit var usersAdapter: UsersAdapter

    @Inject
    lateinit var presenterProvider: Provider<UsersListPresenter>


    private val presenter: UsersListPresenter by moxyPresenter { presenterProvider.get() }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_users_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("TAG","on view cr.")
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        setUpOnClickListeners()
    }

    private fun setUpOnClickListeners() {
        fab.setOnClickListener {
            presenter.onFabClicked()
        }
    }


    private fun setUpAdapter() {
        usersAdapter = UsersAdapter()
        recyclerViewCities.apply {
            setUpAdapterObservers()
            adapter = usersAdapter
        }
    }

    private fun setUpAdapterObservers() {

        usersAdapter.event.observe(viewLifecycleOwner, {
            when (it) {
                is UserItemEvent.OnNoteClick -> {
                    presenter.onUserSelected(it.id)
                }
            }
        })
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun addAllUsers(users: List<User>) {
        Log.d("TAG","Adding all users")
        usersAdapter.submitList(users)
    }
}