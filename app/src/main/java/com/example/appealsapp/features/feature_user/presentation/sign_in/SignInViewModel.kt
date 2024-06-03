package com.example.appealsapp.features.feature_user.presentation.sign_in

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.appealsapp.Screen
import com.example.appealsapp.datastore.DataStoreRepository

import com.example.appealsapp.features.feature_user.data.remote.UserService
import com.example.appealsapp.features.feature_user.data.remote.dto.UserRequestSignIn

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val userService: UserService, private val dataStoreRepository: DataStoreRepository) : ViewModel() {


    fun login(userRequestSignIn: UserRequestSignIn, navController: NavController, context: Context) {
        viewModelScope.launch {
            try {
                userService.login(userRequestSignIn)
                userService.login(userRequestSignIn)
                    ?.let { dataStoreRepository.saveUserId("user_id", it.id) }
                Toast.makeText(context, "Вы успешно авторизовались!", Toast.LENGTH_LONG).show()
                navController.navigate(Screen.AppealsScreen.route)
            } catch (e: Exception) {
                Log.e("SignInViewModel", "login: ", e)
                Toast.makeText(context, "Авторизация провалена!\nПроверьте правильность вводимых данных!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
