package com.example.appealsapp.features.feature_user.presentation.sign_in

import androidx.lifecycle.ViewModel
import com.example.appealsapp.features.feature_user.data.remote.UserService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val userService: UserService) : ViewModel() {



}