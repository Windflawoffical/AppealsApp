package com.example.appealsapp.features.feature_appeal.presentation.add_edit_appeal

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appealsapp.features.feature_appeal.data.remote.AppealService
import com.example.appealsapp.features.feature_appeal.data.remote.dto.AppealRequest
import com.example.appealsapp.features.feature_appeal.data.remote.dto.AppealResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditViewModel @Inject constructor(private val appealService: AppealService) : ViewModel ()
{
    private val _state = mutableStateOf(AppealState())
    val state: State<AppealState> = _state

    fun get_appeal_by_id(id: Int) {
        viewModelScope.launch {
            try {
                _state.value = state.value.copy(isLoading = true)
                _state.value = state.value.copy(
                    appeal = appealService.getAppealById(id),
                    isLoading = false
                )
            } catch(e: Exception) {
                Log.e("AddEditViewModel", "getAppealById: ", e)
                _state.value = state.value.copy(isLoading = false)
            }
        }
    }

    data class AppealState(
        val appeal: AppealResponse? = null,
        val isLoading: Boolean = false
    )
}