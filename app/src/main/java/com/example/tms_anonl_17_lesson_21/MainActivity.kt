package com.example.tms_anonl_17_lesson_21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tms_anonl_17_lesson_21.databinding.ActivityMainBinding
import java.util.Date

class MainActivity : AppCompatActivity() {
    private val binding = ActivityMainBinding.inflate(layoutInflater)

    private val adapter = NotesRecyclerViewAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recycler.adapter = adapter
        binding.addButton.setOnClickListener {
            val newMote = Note(
                binding.headerEditText.text?.toString() ?: "",
                binding.textEditText.text?.toString() ?: "",
                Date().toString()
            )
            NotesHolder.notes.add(newMote)
            adapter.update(NotesHolder.notes)
            binding.headerEditText.setText("")
            binding.textEditText.setText("")
        }
    }
}