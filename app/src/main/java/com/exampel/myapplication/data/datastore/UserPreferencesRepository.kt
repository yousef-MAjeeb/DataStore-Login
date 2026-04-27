package com.exampel.myapplication.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferencesRepository(private val context: Context) {
    suspend fun saveUser(username: String, password: String){
        context.dataStore.edit { preferences ->
            preferences[USERNAME_KEY] = username
            preferences[PASSWORD_KEY] = password
        }
    }

    fun getUserName(): Flow<String>{
        return context.dataStore.data.map { pref ->
            pref[USERNAME_KEY] ?: ""
        }
    }

    fun getPassword(): Flow<String>{
        return context.dataStore.data.map { pref ->
            pref[PASSWORD_KEY] ?: ""
        }
    }
}