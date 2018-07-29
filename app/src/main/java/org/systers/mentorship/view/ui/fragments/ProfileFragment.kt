package org.systers.mentorship.view.ui.fragments

import org.systers.mentorship.R
import org.systers.mentorship.view.ui.BaseFragment

class ProfileFragment : BaseFragment() {
//class HomeFragment : BaseFragment<MainActivity> {

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_profile
    }

    override fun getTitleResourceId(): Int {
        return R.string.fragment_title_profile
    }

    companion object {
        fun newInstance() = ProfileFragment()
        private const val TAG = "ProfileFragment"
    }
}