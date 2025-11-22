package com.ibrohimapk3.notest1.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrohimapk3.notest1.model.NoteEntity
import com.ibrohimapk3.notest1.model.repository.NoteRepository
import kotlinx.coroutines.launch

class AddItemViewModel(private var repository: NoteRepository): ViewModel() {
    fun addItem(item : NoteEntity){
        viewModelScope.launch {
            repository.insertItem(item)
        }
    }
}