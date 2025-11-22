package com.ibrohimapk3.notest1.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrohimapk3.notest1.model.NoteEntity
import com.ibrohimapk3.notest1.model.repository.NoteRepository
import kotlinx.coroutines.launch

class MainFragmentViewModel(private var repository: NoteRepository): ViewModel() {
    fun getAllItems(): LiveData<List<NoteEntity>> {
        return repository.getAllItem()
    }

    fun deleteItem(title:String){
        viewModelScope.launch {
            repository.deleteItemByTitle(title)
        }
    }
}