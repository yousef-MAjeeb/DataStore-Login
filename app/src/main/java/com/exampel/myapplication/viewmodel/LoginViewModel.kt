package com.exampel.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exampel.myapplication.data.datastore.UserPreferencesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class LoginViewModel(private val repo: UserPreferencesRepository): ViewModel() {

    val username = repo.getUserName().stateIn(viewModelScope, SharingStarted.Lazily,"")
    val password = repo.getPassword().stateIn(viewModelScope, SharingStarted.Lazily,"")

    fun updateUsername(newUsername: String){
        viewModelScope.launch {
            repo.saveUser(newUsername, password.value)
        }
    }

    fun updatePassword(newPassword: String){
        viewModelScope.launch {
            repo.saveUser(username.value, newPassword)

        }
    }

    fun login(username: String, password: String){
        viewModelScope.launch {
            repo.saveUser(username,password)
        }
    }
}