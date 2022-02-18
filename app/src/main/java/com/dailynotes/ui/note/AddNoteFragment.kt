package com.dailynotes.ui.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.dailynotes.R
import com.dailynotes.databinding.FragmentAddNoteBinding
import com.dailynotes.model.Note
import com.dailynotes.viewmodel.NoteViewModel

class AddNoteFragment : Fragment() {

    private lateinit var noteViewModel: NoteViewModel
    private var _binding: FragmentAddNoteBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        noteViewModel = ViewModelProvider(this)[NoteViewModel::class.java]
        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)

        binding.btGuardar.setOnClickListener {
            insertarNote()
        }

        return binding.root
    }

    private fun insertarNote() {
        val fecha = binding.etFecha.text.toString()
        if(fecha.isNotEmpty()){
            val bueno = binding.etBueno.text.toString()
            val descripcion = binding.etDescription.text.toString()
            val nota = Note(0, fecha, bueno, descripcion)
            noteViewModel.addNote(nota)
        } else {
            Toast.makeText(requireContext(), getString(R.string.msg_agregado), Toast.LENGTH_SHORT).show()
        }

        findNavController().navigate(R.id.action_addNoteFragment_to_nav_note)
    }


}