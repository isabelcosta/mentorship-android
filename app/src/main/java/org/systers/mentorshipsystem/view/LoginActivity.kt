package org.systers.mentorshipsystem.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_login.*
import org.systers.mentorshipsystem.R
import org.systers.mentorshipsystem.viewmodel.LoginViewModel
import org.systers.mentorshipsystem.databinding.ActivityLoginBinding
import org.systers.mentorshipsystem.util.EventWrapper

class LoginActivity : AppCompatActivity() {

    companion object {
        const val TAG = "LoginActivity"
    }

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.vm = viewModel
        observeViewModelFields(viewModel)
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy()")
        super.onDestroy()
    }

    private fun observeViewModelFields(viewModel: LoginViewModel) {

        viewModel.showOrHideUsernameError.observe(this, Observer<String> {
            loginUsernameInputText.error = it
        })

        viewModel.navigateToRegistration.observe(this, Observer<EventWrapper<Boolean>> {
            it?.getContentIfNotHandled()?.let { // Only proceed if the event has never been handled
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        })
        viewModel.isLoading.observe(this, Observer<Boolean> {
            it?.let {
                if (it) {
                    loginProgressBar.show()
                } else {
                    loginProgressBar.hide()
                }
            }
        })

        viewModel.showOrHidePasswordError.observe(this, Observer<String> {
            loginPasswordInputText.error = it
        })
    }
}

