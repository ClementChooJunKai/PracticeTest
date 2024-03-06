package com.example.practicetest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class RepoViewModel(private val repository: Repo) : ViewModel() {

    val allDigits = repository.numbers.stateIn(
        scope = viewModelScope, // Coroutine scope
        started = SharingStarted.WhileSubscribed(), // When to start collecting
        initialValue = emptyList()
    )

    fun insert(digit: Int) = viewModelScope.launch {
        val newFourDigit = Entity(testNum = digit)
        repository.insert(newFourDigit)

    }

    fun clearAllNumbers() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }

    fun update(digit: Int) = viewModelScope.launch {
        val digit1 = Entity(testNum = digit)
        repository.update(entityNum = digit1)
    }


    class ViewModelFactory(private val repository: Repo) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(RepoViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return RepoViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}