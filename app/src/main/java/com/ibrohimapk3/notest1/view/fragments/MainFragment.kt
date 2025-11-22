package com.ibrohimapk3.notest1.view.fragments
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ibrohimapk3.notest1.R
import com.ibrohimapk3.notest1.model.MainDb
import com.ibrohimapk3.notest1.model.repository.NoteRepository
import com.ibrohimapk3.notest1.view.CallBack
import com.ibrohimapk3.notest1.view.ItemsData
import com.ibrohimapk3.notest1.view.MyAdapter
import com.ibrohimapk3.notest1.viewModel.AddItemViewModel
import com.ibrohimapk3.notest1.viewModel.MainFragmentViewModel

class MainFragment : Fragment()  , CallBack{
    private lateinit var viewModel: MainFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_main, container, false)
        var dao = MainDb.createDb(requireContext()).getDao()
        var repository = NoteRepository(dao)
        var adapter = MyAdapter(this)
        viewModel = MainFragmentViewModel(repository)
        var imgButton = view.findViewById<ImageButton>(R.id.btn_add)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        imgButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_addItemFragment)
        }
        var list = mutableListOf<ItemsData>()

        viewModel.getAllItems().observe(viewLifecycleOwner) {it->
            list.clear()
            for(i in it){
                list.add(ItemsData(i.title.toString() , i.content ))
            }
            adapter.setData(list)
        }
        recyclerView.adapter = adapter
        return view
    }

    override fun onItemClick(itemsData: ItemsData) {

        val bundle = Bundle().apply {
            putString("title", itemsData.title)
            putString("content", itemsData.contain)
        }

        findNavController().navigate(R.id.action_mainFragment_to_infoAboutItemFragment , bundle)
    }

    override fun deleteItem(title: String) {
        viewModel.deleteItem(title)
    }
}