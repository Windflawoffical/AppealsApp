package com.example.appealsapp.features.feature_appeal.presentation.add_edit_appeal

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.appealsapp.Screen
import com.example.appealsapp.features.feature_appeal.presentation.SharedViewModel
import com.example.appealsapp.features.feature_user.data.remote.dto.UserRequest

@Composable
fun AddEditAppealScreen(
    navController: NavController,
    viewModel: AddEditViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel
) {
    Column(
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp)
    ) {



        val title = remember { mutableStateOf(("")) }
        val description = remember { mutableStateOf(("")) }

        val sharedTitle = sharedViewModel.title.value
        val sharedDescription = sharedViewModel.description.value

        val textforbutton: String
        if (sharedTitle == "" && sharedDescription == "") {
            textforbutton = "Create appeal"
        } else {
            textforbutton = "Update appeal"
        }

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            modifier = Modifier.width(200.dp),
            label = { Text(text = "Title") },
            value = sharedTitle,
            onValueChange = { title.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Description") },
            value = sharedDescription,
            onValueChange = { description.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier.padding(20.dp)
        )
        {
            Button(
                onClick = { navController.navigate(Screen.AppealsScreen.route) },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(textforbutton)
            }
        }
    }
}