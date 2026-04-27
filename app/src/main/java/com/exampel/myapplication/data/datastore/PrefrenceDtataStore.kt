package com.exampel.myapplication.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore("credentials")

val USERNAME_KEY = stringPreferencesKey("username")
val PASSWORD_KEY = stringPreferencesKey("password")
