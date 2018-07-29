package org.systers.mentorship.view.ui.fragments

import org.systers.mentorship.R
import org.systers.mentorship.view.ui.BaseFragment

class MembersFragment : BaseFragment() {
//class HomeFragment : BaseFragment<MainActivity> {

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_members
    }

    override fun getTitleResourceId(): Int {
        return R.string.fragment_title_members
    }

    companion object {
        fun newInstance() = MembersFragment()
        private const val TAG = "MembersFragment"

    }
}