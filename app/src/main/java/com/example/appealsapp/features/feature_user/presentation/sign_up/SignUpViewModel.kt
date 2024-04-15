package com.example.appealsapp.features.feature_user.presentation.sign_up

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appealsapp.features.feature_appeal.data.remote.dto.AppealResponse
import com.example.appealsapp.features.feature_user.data.remote.UserService
import com.example.appealsapp.features.feature_user.data.remote.dto.UserResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val userService: UserService) : ViewModel () {

    private val _state = mutableStateOf(UserState())
    val state: State<UserState> = _state

    init {
        get_users()
    }

    fun get_users() {
        viewModelScope.launch {
            try {
                _state.value = state.value.copy(isLoading = true)
                _state.value = state.value.copy(
                    users = userService.getUsers(),
                    isLoading = false
                )
            } catch(e: Exception) {
                Log.e("UsersViewModel", "getUsers: ", e)
                _state.value = state.value.copy(isLoading = false)
            }
        }
    }

    data class UserState(
        val users: List<UserResponse>? = null,
        val isLoading: Boolean = false
    )

}