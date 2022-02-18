package com.dailynotes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dailynotes.databinding.NoteFilaBinding
import com.dailynotes.model.Note

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(){
    private var listaNotes = emptyList<Note>()
    //Card
    inner class NoteViewHolder(private val itemBinding: NoteFilaBinding) :
        RecyclerView.ViewHolder(itemBinding.root){
        fun bind(note: Note){
            itemBinding.tvFecha.text = note.fecha
            itemBinding.tvBueno.text = note.bueno
            itemBinding.tvDescripcion.text = note.descripcion
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemBinding = NoteFilaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val noteActual = listaNotes[position]
        holder.bind(noteActual)
    }

    override fun getItemCount(): Int {
        return listaNotes.size
    }

    fun setData(notes: List<Note>){
        this.listaNotes = notes
        notifyDataSetChanged()
    }
}