package org.systers.mentorship.view.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import org.systers.mentorship.R
import org.systers.mentorship.remote.requests.LoginRequest
import org.systers.mentorship.viewmodels.LoginViewModel

/**
 * This activity will let the user to login using username/email and password.
 */
class LoginActivity : BaseActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        loginViewModel.successful.observe(this, Observer {
            successful ->
            hideProgressDialog()
            if (successful != null) {
                if (successful) {
                    Toast.makeText(this, R.string.logging_successful, Toast.LENGTH_LONG)
                            .show()
                    intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Snackbar.make(getRootView(), loginViewModel.message, Snackbar.LENGTH_LONG)
                            .show()
                }
            }
        })

        btnLogin.setOnClickListener {
            val username = editTextLoginUsername.text.toString()
            val password = editTextLoginPassword.text.toString()

            if (areValidInputs(username, password)) {
                loginViewModel.login(LoginRequest(username, password))
                showProgressDialog(getString(R.string.logging_in))
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        loginViewModel.successful.removeObservers(this)
        loginViewModel.successful.value = null
    }

    /**
     * Checks if [username] and [password] are valid for a login operation
     *
     * @param username login username or email
     * @param password login password
     * @return true if both [username] and [password] are valid, false if otherwise
     */
    private fun areValidInputs(username: String, password: String) : Boolean {
        var isValidInput = true

        if (username.isEmpty()) {
            inputTextLoginUsername.error = getString(R.string.error_empty_login_username)
            isValidInput = false
        } else {
            inputTextLoginUsername.error = null
        }

        if (password.isEmpty()) {
            inputTextLoginPassword.error = getString(R.string.error_empty_login_password)
            isValidInput = false
        } else {
            inputTextLoginPassword.error = null
        }

        return isValidInput
    }
}
