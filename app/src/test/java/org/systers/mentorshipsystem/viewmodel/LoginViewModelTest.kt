package org.systers.mentorshipsystem.viewmodel

import org.junit.Before
import org.mockito.MockitoAnnotations

class LoginViewModelTest {

    lateinit var loginViewModel: LoginViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        loginViewModel = LoginViewModel()
    }
}