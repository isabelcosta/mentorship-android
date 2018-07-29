package org.systers.mentorship.view.ui.fragments

import org.systers.mentorship.R
import org.systers.mentorship.view.ui.BaseFragment

/**
 * The fragment is responsible for showing the all mentorship requests
 * and filtered lists such as for pending requests and past relations and requests
 */
class RequestsFragment : BaseFragment() {

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_requests
    }

    override fun getTitleResourceId(): Int {
        return R.string.fragment_title_requests
    }

    companion object {
        fun newInstance() = RequestsFragment()
        private const val TAG = "RequestsFragment"

    }
}