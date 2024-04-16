package com.example.appealsapp.features.feature_appeal.presentation.appeals

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.appealsapp.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppealsScreen(
    navController: NavController,
    viewModel: AppealsViewModel = hiltViewModel()) {

    val state = viewModel.state.value

    state.appeals?.let {
        LazyColumn {
            items(state.appeals) {
                Card(
                    onClick = { navController.navigate(Screen.AddEditAppealScreen.route) },
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp).fillMaxWidth(),
                ) {
                    Text(text = it.description, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = it.user.nickname, fontSize = 14.sp)

                }
            }
        }
    }


//    Card(
//        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp).fillMaxWidth(),
//        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
//    ) {
//        Row {
//            state.appeals?.let {
//                LazyColumn {
//                    items(state.appeals) {
//                        Column(
//                            modifier = Modifier.fillMaxWidth().padding(16.dp)
//
//                        ) {
//                            Text(text = it.description, fontSize = 20.sp)
//                            Spacer(modifier = Modifier.height(4.dp))
//                            Text(text = it.user.nickname, fontSize = 14.sp)
//                        }
//                    }
//                }
//            }
//        }
//    }
}