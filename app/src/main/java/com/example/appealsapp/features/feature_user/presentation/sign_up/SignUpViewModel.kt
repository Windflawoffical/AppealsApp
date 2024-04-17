package com.example.appealsapp.features.feature_user.presentation.sign_up

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appealsapp.features.feature_appeal.data.remote.dto.AppealResponse
import com.example.appealsapp.features.feature_appeal.presentation.appeals.AppealsViewModel
import com.example.appealsapp.features.feature_user.data.remote.UserService
import com.example.appealsapp.features.feature_user.data.remote.dto.UserRequest
import com.example.appealsapp.features.feature_user.data.remote.dto.UserResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val userService: UserService) : ViewModel ()
{

    fun createUser(userRequest: UserRequest) {
        viewModelScope.launch {
            try {
                userService.createUser(userRequest)
            } catch (e: Exception) {
                Log.e("SignUpViewModel", "createUser: ", e)
            }
        }
    }

}