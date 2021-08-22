package com.aesc.roomdatabase.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.aesc.roomdatabase.R
import com.aesc.roomdatabase.models.Note
import kotlinx.android.synthetic.main.item_layout_notes.view.*

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    private var noteList: List<Note> = listOf()

    fun setNotes(pokemonList: List<Note>) {
        this.noteList = pokemonList
        notifyDataSetChanged()
    }

    private fun ViewGroup.inflate(
        @LayoutRes layoutRes: Int,
        attachRoot: Boolean = false
    ): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachRoot)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_layout_notes, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_title.text = noteList[position].title
        holder.itemView.tv_description.text = noteList[position].description
//        holder.itemView.btnDeleteTest.setOnClickListener(this)
    }

    override fun getItemCount() = noteList.size

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val item: Note = noteList[adapterPosition]
            println("DEBUG -> ${item.id}")
        }

    }
}