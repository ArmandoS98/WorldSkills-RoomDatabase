package com.aesc.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aesc.roomdatabase.adapters.NoteAdapter
import com.aesc.roomdatabase.models.Note
import com.aesc.roomdatabase.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btnDeleteTest
import kotlinx.android.synthetic.main.activity_main.btnUpdateTest
import kotlinx.android.synthetic.main.item_layout_notes.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var adapter: NoteAdapter
    lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = NoteViewModel(this.application)
        cargarNotes()
        btnAddTest.setOnClickListener(this)
        btnUpdateTest.setOnClickListener(this)
        btnDeleteTest.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnAddTest -> {
                val note = Note(0, "Task 2", "Description 2")
                viewModel.addNote(note)
            }
            R.id.btnUpdateTest -> {
                println("Update")
                val note = Note(2, "Tarea De Repaso 2", "22/08/2021")
                viewModel.updateNote(note)
                cargarNotes()
            }
            R.id.btnDeleteTest -> {
                println("Delete")
                val note = Note(1, "Task 2", "Description 2")
                viewModel.deleteNote(note)
            }
        }


    }

    private fun cargarNotes() = viewModel.getNotes.observe(this) {
        it?.forEach { note ->
            cargarRecyclerViewNotas(it)
        }
    }

    private fun cargarRecyclerViewNotas(it: List<Note>) {
        NoteAdapter().setNotes(it)
        recyclerInit(it)
    }

    private fun recyclerInit(top: List<Note>) {
        adapter = NoteAdapter()
        adapter.setNotes(top)
        recyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerview.adapter = adapter
    }
}