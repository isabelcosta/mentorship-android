package org.systers.mentorshipsystem.view

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_login.*
import org.systers.mentorshipsystem.R
import org.systers.mentorshipsystem.application.MentorshipSystemApplication
import org.systers.mentorshipsystem.databinding.ActivityLoginBinding
import org.systers.mentorshipsystem.databinding.ActivityMainBinding
import org.systers.mentorshipsystem.model.response.LoginResponseData
import org.systers.mentorshipsystem.util.EventWrapper
import org.systers.mentorshipsystem.viewmodel.LoginViewModel
import org.systers.mentorshipsystem.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.vm = viewModel
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy()")
        super.onDestroy()
    }

}
