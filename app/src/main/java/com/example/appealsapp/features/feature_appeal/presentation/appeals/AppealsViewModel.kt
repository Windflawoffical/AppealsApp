package com.example.appealsapp.features.feature_appeal.presentation.appeals

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appealsapp.features.feature_appeal.data.remote.AppealService
import com.example.appealsapp.features.feature_appeal.data.remote.AppealServiceImpl
import com.example.appealsapp.features.feature_appeal.data.remote.dto.AppealResponse
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppealsViewModel @Inject constructor(private val appealService: AppealService): ViewModel()
{
    private val _state = mutableStateOf(AppealState())
    val state: State<AppealState> = _state

    init {
        get_appeals()
    }

    fun get_appeals() {
        viewModelScope.launch {
            try {
                _state.value = state.value.copy(isLoading = true)
                _state.value = state.value.copy(
                    appeals = appealService.getAppeals(),
                    isLoading = false
                )
            } catch(e: Exception) {
                Log.e("AppealsViewModel", "getAppeals: ", e)
                _state.value = state.value.copy(isLoading = false)
            }
        }
    }

    data class AppealState(
        val appeals: List<AppealResponse>? = null,
        val isLoading: Boolean = false
    )

}