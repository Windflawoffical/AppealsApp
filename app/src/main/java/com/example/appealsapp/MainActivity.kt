package com.example.appealsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appealsapp.features.feature_appeal.presentation.SharedViewModel
import com.example.appealsapp.features.feature_appeal.presentation.add_edit_appeal.AddEditAppealScreen
import com.example.appealsapp.features.feature_appeal.presentation.appeals.AppealsScreen
import com.example.appealsapp.features.feature_user.presentation.sign_in.SignInScreen
import com.example.appealsapp.features.feature_user.presentation.sign_up.SignUpScreen
import com.example.appealsapp.ui.theme.AppealsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppealsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background)
                {
                    val navController = rememberNavController()
                    val sharedViewModel: SharedViewModel = viewModel()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.SignInScreen.route
                    ) {
                        composable(route = Screen.SignInScreen.route) {
                            SignInScreen(navController = navController)
                        }
                        composable(route = Screen.SignUpScreen.route) {
                            SignUpScreen(navController = navController)
                        }
                        composable(route = Screen.AddEditAppealScreen.route) {
                            AddEditAppealScreen(navController = navController, sharedViewModel = sharedViewModel)
                        }
                        composable(route = Screen.AppealsScreen.route) {
                            AppealsScreen(navController = navController, sharedViewModel = sharedViewModel)
                        }
                    }
                }
            }
        }
    }
}
