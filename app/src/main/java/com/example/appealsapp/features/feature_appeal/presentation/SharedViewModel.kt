package com.example.appealsapp.features.feature_appeal.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel () {

    private val _title:MutableState<String> = mutableStateOf("")
    val title: State<String> =_title

    private val _description:MutableState<String> = mutableStateOf("")
    val description: State<String> =_description

    fun setTitle(data:String) {
        _title.value = data
    }
    fun setDescription(data:String) {
        _description.value = data
    }

}