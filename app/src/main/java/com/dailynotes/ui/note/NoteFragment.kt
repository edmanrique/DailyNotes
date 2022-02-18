package com.dailynotes.ui.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dailynotes.R
import com.dailynotes.adapter.NoteAdapter
import com.dailynotes.databinding.FragmentNoteBinding
import com.dailynotes.viewmodel.NoteViewModel

class NoteFragment : Fragment() {

    private lateinit var noteViewModel: NoteViewModel
    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        _binding = FragmentNoteBinding.inflate(inflater, container, false)

        binding.fbAgregar.setOnClickListener{
            findNavController().navigate(R.id.action_nav_note_to_addNoteFragment)
        }

        val noteAdapter = NoteAdapter()
        val reciclador = binding.reciclador
        reciclador.adapter = noteAdapter
        reciclador.layoutManager = LinearLayoutManager(requireContext())

        noteViewModel = ViewModelProvider(this)[NoteViewModel::class.java]

        noteViewModel.getAllData.observe(viewLifecycleOwner) { notes ->
            noteAdapter.setData(notes)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}