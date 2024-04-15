package com.example.appealsapp.features.feature_appeal.data

import com.example.appealsapp.features.feature_user.data.User

data class Appeal(
    val id: Long,
    val description: String,
    val user: User
) {
    companion object {
        private const val ACCEPTED_FOR_WORK = "ACCEPTED_FOR_WORK"
        private const val IN_WORK = "IN_WORK"
        private const val DONE = "DONE"
    }
}


