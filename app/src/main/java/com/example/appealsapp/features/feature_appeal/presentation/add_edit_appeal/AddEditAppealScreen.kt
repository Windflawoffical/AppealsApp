package com.example.appealsapp.features.feature_appeal.presentation.add_edit_appeal

import android.content.Context
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
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.appealsapp.Screen
import com.example.appealsapp.datastore.DataStoreRepository
import com.example.appealsapp.datastore.DataStoreRepositoryImpl
import com.example.appealsapp.features.feature_appeal.data.remote.dto.AppealRequest
import com.example.appealsapp.features.feature_appeal.presentation.SharedViewModel
import com.example.appealsapp.features.feature_user.data.remote.dto.UserRequestCreateAppeal
import kotlinx.coroutines.runBlocking

@Composable
fun AddEditAppealScreen(
    navController: NavController,
    viewModel: AddEditViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel,
    context: Context
) {

    Column(
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp)
    ) {


        var sharedTitle = sharedViewModel.title.value
        var sharedDescription = sharedViewModel.description.value

        val title = remember { mutableStateOf(sharedTitle) }
        val description = remember { mutableStateOf(sharedDescription) }

        val textforbutton: String
        if (sharedTitle == "" && sharedDescription == "") {
            textforbutton = "Создать заявку"
        } else {
            textforbutton = "Обновить заявку"
        }

        val dataStoreRepository = DataStoreRepositoryImpl(context)
        val mylong = runBlocking {
            dataStoreRepository.getUserId("user_id")
        }
        println(mylong)
        val myuserRequestCreateAppeal = mylong?.let { UserRequestCreateAppeal(it) }

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            modifier = Modifier.width(200.dp),
            label = { Text(text = "Проблема") },
            value = title.value,
            onValueChange = { title.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Краткое описание") },
            value = description.value,
            onValueChange = { description.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier.padding(20.dp)
        )

        {val appealRequest = myuserRequestCreateAppeal?.let { AppealRequest(description.value, it) }
            Button(
                onClick = { println(appealRequest)
                    appealRequest?.let { viewModel.create_appeal(it, navController, context) } },
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