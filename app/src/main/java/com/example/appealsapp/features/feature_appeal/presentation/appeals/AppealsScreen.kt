package com.example.appealsapp.features.feature_appeal.presentation.appeals

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.appealsapp.Screen


@Composable
fun AppealsScreen(
    navController: NavController,
    viewModel: AppealsViewModel = hiltViewModel())
{

    val state = viewModel.state.value

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        state.appeals?.let {
            LazyColumn {
                items(state.appeals) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(text = it.description, fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }
        }
        Button(
            onClick = { navController.navigate(Screen.AddEditAppealScreen.route) }
        ) {
            Text(text = "Next Screen")
        }
    }
}