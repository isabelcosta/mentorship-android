package org.systers.mentorship.view.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.systers.mentorship.view.ui.activities.MainActivity

abstract class BaseFragment : Fragment() {
//abstract class BaseFragment<S : BaseActivity> : Fragment() {

//    protected lateinit var activity: S
    protected lateinit var rootView : ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        activity = activity as S
        (activity as MainActivity).let {
            it.supportActionBar?.title = getString(getTitleResourceId())
        }
        val todo = ""
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        rootView = inflater?.inflate(getLayoutResourceId(), container, false) as ViewGroup
        return rootView
    }

    /**
     * This function is responsible to return the layout resource id of the fragment,
     * so that the view can be set by the parent fragment
     * @return layout resource id of the fragment child view
     */
    protected abstract fun getLayoutResourceId() : Int

    /**
     * This function is responsible to return the string id of the title of the fragment,
     * so that the title can be set on the Action bar by the parent fragment
     * @return string of the title of the fragment
     */
    protected abstract fun getTitleResourceId() : Int
}