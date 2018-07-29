package org.systers.mentorship.view.ui.fragments

import org.systers.mentorship.R
import org.systers.mentorship.view.ui.BaseFragment

class RelationFragment : BaseFragment() {

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_relation
    }

    override fun getTitleResourceId(): Int {
        return R.string.fragment_title_relation
    }

    companion object {
        fun newInstance() = RelationFragment()
        private const val TAG = "RelationFragment"

    }
}