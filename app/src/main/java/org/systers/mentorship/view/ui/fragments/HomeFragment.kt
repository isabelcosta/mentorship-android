package org.systers.mentorship.view.ui.fragments

import org.systers.mentorship.R
import org.systers.mentorship.view.ui.BaseFragment

class HomeFragment : BaseFragment() {

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_home
    }

    override fun getTitleResourceId(): Int {
        return R.string.fragment_title_home
    }

    companion object {
        fun newInstance() = HomeFragment()
        private const val TAG = "HomeFragment"

    }
}