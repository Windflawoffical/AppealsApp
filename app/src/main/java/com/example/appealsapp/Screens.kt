package com.example.appealsapp

sealed class Screen(val route: String) {
    object AddEditAppealScreen: Screen("AddEditAppealScreen")
    object AppealsScreen: Screen("AppealsScreen")
    object SignInScreen: Screen("SignInScreen")
    object SignUpScreen: Screen("SignUpScreen")
}