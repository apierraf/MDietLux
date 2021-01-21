package com.example.mdietlux.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStore(val context: Context) {

    private val dataStore = context.createDataStore(name = "settings_pref")


    companion object {
        val AGE = intPreferencesKey("_age")
        val HEIGTH = intPreferencesKey("_heigth")
        val WEIGTH = intPreferencesKey("_weigth")
        val WEIGTHOBJ = intPreferencesKey("_weigth_obj")
    }

    suspend fun saveDataAge(age: Int){
        dataStore.edit { preferences ->
            preferences[AGE] = age
        }
    }

    val currentAge: Flow<Int?>
        get() = dataStore.data.map { preferences ->
            preferences[AGE]
        }

    suspend fun saveDataHeigth(heigth: Int){
        dataStore.edit { preferences ->
            preferences[HEIGTH] = heigth
        }
    }

    val currentHeigth: Flow<Int?>
        get() = dataStore.data.map { preferences ->
            preferences[HEIGTH]
        }

    suspend fun saveDataWeigth(weigth: Int){
        dataStore.edit { preferences ->
            preferences[WEIGTH] = weigth
        }
    }

    val currentWeigth: Flow<Int?>
        get() = dataStore.data.map { preferences ->
            preferences[WEIGTH]
        }
    suspend fun saveDataWeigthOBJ(weigth: Int){
        dataStore.edit { preferences ->
            preferences[WEIGTHOBJ] = weigth
        }
    }

    val currentWeigthOBJ: Flow<Int?>
        get() = dataStore.data.map { preferences ->
            preferences[WEIGTHOBJ]
        }
}