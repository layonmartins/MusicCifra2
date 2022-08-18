package com.example.testciframusic

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.testciframusic.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.editTextMusic.setText(musicMock)
        binding.button.setOnClickListener {
            val music = binding.editTextMusic.text.toString()
            Log.d("layon.f", "music = $music")
            val bundle = bundleOf("music" to music)
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    val musicMock : String =
    "Em       D        G\n" +
    "Vem, vem Espirito Santo\n" +
    "D                Am\n" +
    "Renova minha vida...\n"
}