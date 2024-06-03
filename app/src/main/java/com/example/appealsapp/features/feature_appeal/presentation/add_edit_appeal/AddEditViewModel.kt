package com.example.appealsapp.features.feature_appeal.presentation.add_edit_appeal

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.appealsapp.Screen
import com.example.appealsapp.features.feature_appeal.data.remote.AppealService
import com.example.appealsapp.features.feature_appeal.data.remote.dto.AppealRequest
import com.example.appealsapp.features.feature_appeal.data.remote.dto.AppealResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditViewModel @Inject constructor(private val appealService: AppealService) : ViewModel ()
{

//    fun get_appeal_by_id(id: Int) {
//        viewModelScope.launch {
//            try {
//                _state.value = state.value.copy(isLoading = true)
//                _state.value = state.value.copy(
//                    appeal = appealService.getAppealById(id),
//                    isLoading = false
//                )
//            } catch(e: Exception) {
//                Log.e("AddEditViewModel", "getAppealById: ", e)
//                _state.value = state.value.copy(isLoading = false)
//            }
//        }
//    }

    fun create_appeal(appealRequest: AppealRequest, navController: NavController, context: Context) {
        viewModelScope.launch {
            try {
                appealService.createAppeal(appealRequest)
                navController.navigate(Screen.AppealsScreen.route)
                Toast.makeText(context, "Заявка успешно создана!", Toast.LENGTH_LONG).show()
            } catch(e: Exception) {
                Log.e("AddEditViewModel", "create_appeal: ", e)
            }
        }
    }

}