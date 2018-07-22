package org.systers.mentorshipsystem.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_login.*
import org.systers.mentorshipsystem.R
import org.systers.mentorshipsystem.viewmodel.LoginViewModel
import org.systers.mentorshipsystem.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.vm = viewModel

        viewModel.showOrHideUsernameError.observe(this, Observer<String> {
            loginUsernameInputText.error = it
        })

        viewModel.showOrHidePasswordError.observe(this, Observer<String> {
            loginPasswordInputText.error = it
        })
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy()")
        super.onDestroy()
    }

}

const val TAG = "LoginActivity"