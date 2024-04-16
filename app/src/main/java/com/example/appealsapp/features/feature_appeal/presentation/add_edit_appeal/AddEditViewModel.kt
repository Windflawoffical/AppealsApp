package com.example.appealsapp.features.feature_appeal.presentation.add_edit_appeal

import androidx.lifecycle.ViewModel
import com.example.appealsapp.features.feature_appeal.data.remote.AppealService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditViewModel @Inject constructor(private val appealService: AppealService) : ViewModel ()
{

}