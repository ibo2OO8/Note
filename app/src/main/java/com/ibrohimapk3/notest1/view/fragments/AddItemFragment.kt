package com.ibrohimapk3.notest1.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.ibrohimapk3.notest1.R
import com.ibrohimapk3.notest1.model.MainDb
import com.ibrohimapk3.notest1.model.NoteEntity
import com.ibrohimapk3.notest1.model.repository.NoteRepository
import com.ibrohimapk3.notest1.viewModel.AddItemViewModel

class AddItemFragment : Fragment() {
    private lateinit var viewModel: AddItemViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_add_item, container, false)
        var btnBack = view.findViewById<Button>(R.id.btn_back)
        var btnSave = view.findViewById<Button>(R.id.btn_save)
        var edTitle = view.findViewById<EditText>(R.id.ed_title)
        var edContain = view.findViewById<EditText>(R.id.ed_contain)
        var dao = MainDb.createDb(requireContext()).getDao()
        var repository = NoteRepository(dao)
        viewModel = AddItemViewModel(repository)

        btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_addItemFragment_to_mainFragment)
        }

        btnSave.setOnClickListener {
            if (edTitle.text.toString().isNotBlank() && edContain.text.toString().isNotBlank()) {
                viewModel.addItem(
                    NoteEntity(title = edTitle.text.toString(), content = edContain.text.toString()
                    )
                )
                findNavController().navigate(R.id.action_addItemFragment_to_mainFragment)
            }
        }
        return view
    }

}