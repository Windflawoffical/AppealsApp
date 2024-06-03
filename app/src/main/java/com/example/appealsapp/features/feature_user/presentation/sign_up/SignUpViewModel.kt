package com.example.appealsapp.features.feature_user.presentation.sign_up

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.appealsapp.Screen
import com.example.appealsapp.features.feature_user.data.remote.UserService
import com.example.appealsapp.features.feature_user.data.remote.dto.UserRequestSignUp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.serialization.builtins.serializer
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val userService: UserService) : ViewModel ()
{

    fun createUser(userRequestSignUp: UserRequestSignUp, navController: NavController, context: Context) {
        viewModelScope.launch {
            try {
                userService.createUser(userRequestSignUp)
                navController.navigate(Screen.SignInScreen.route)
                Toast.makeText(context, "Вы успешно зарегистрировались!", Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                Log.e("SignUpViewModel", "createUser: ", e)
                Toast.makeText(context, "Регистрация провалена!\nПроверьте правильность вводимых данных!", Toast.LENGTH_LONG).show()
            }
        }
    }

}