package com.example.appealsapp.features.feature_appeal.presentation.appeals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.appealsapp.Screen
import com.example.appealsapp.features.feature_appeal.presentation.SharedViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppealsScreen(
    navController: NavController,
    viewModel: AppealsViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel
) {

    val state = viewModel.state.value

    state.appeals?.let {
        Column {
            LazyColumn {
                items(state.appeals) {
                    Card(

                        onClick = { navController.navigate(Screen.AddEditAppealScreen.route)
                            sharedViewModel.setTitle(it.id.toString())
                            sharedViewModel.setDescription(it.description)},
                        modifier = Modifier
                            .padding(horizontal = 12.dp, vertical = 12.dp)
                            .fillMaxWidth(),
                    ) {
                        Text(text = it.id.toString(), fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = it.description, fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = it.user.nickname, fontSize = 14.sp)
                    }
                }
            }
            FloatingActionButton(
                onClick = { navController.navigate(Screen.AddEditAppealScreen.route)
                    sharedViewModel.setTitle("")
                    sharedViewModel.setDescription("")},
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp).align(Alignment.End))
            {
                Icon(Icons.Default.Add, "Add")
            }
        }
    }
}