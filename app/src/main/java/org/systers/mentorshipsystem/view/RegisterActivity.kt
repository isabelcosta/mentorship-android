package org.systers.mentorshipsystem.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*
import org.systers.mentorshipsystem.R
import org.systers.mentorshipsystem.databinding.ActivityRegisterBinding
import org.systers.mentorshipsystem.util.EventWrapper
import org.systers.mentorshipsystem.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {

    companion object {
        const val TAG = "RegisterActivity"
    }

    lateinit var binding: ActivityRegisterBinding
    lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        binding.vm = viewModel
        observeViewModelFields(viewModel)

    }

    private fun observeViewModelFields(viewModel: RegisterViewModel) {

        viewModel.apply {

            mismatchPasswordsError.observe(this@RegisterActivity, Observer<String> {
                confirmPasswordTextInputLayout.error = it
            })

            navigateToLogin.observe(this@RegisterActivity, Observer<EventWrapper<Boolean>> {
                it?.getContentIfNotHandled()?.let { // Only proceed if the event has never been handled
                    this@RegisterActivity.onBackPressed()
                }
            })

        }
    }
}
