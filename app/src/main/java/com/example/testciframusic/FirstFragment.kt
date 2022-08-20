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
            val bundle = bundleOf("music" to music)
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    val musicMock : String =
    "C       D        E\n" +
    "Vem, vem Espirito Santo\n" +
    "F     G    A      B\n" +
    "Renova minha vida...\n" +
    "Cm       Dm        Em\n" +
    "Vem, vem Espirito Santo\n" +
    "Fm     Gm    Am      Bm\n" +
    "Renova minha vida...\n" +
    "C       Db        Eb\n" +
    "Vem, vem Espirito Santo\n" +
    "F     Gb    Ab      Bb\n" +
    "Renova minha vida...\n" +
    "C#       D#        E\n" +
    "Vem, vem Espirito Santo\n" +
    "F#     G#    A#      B\n" +
    "Renova minha vida...\n" +
    "C#m       D#m        Em\n" +
    "Vem, vem Espirito Santo\n" +
    "F#m     G#m    A#m      Bm\n" +
    "Renova minha vida...\n" +
    "Cm       Dbm        Ebm\n" +
    "Vem, vem Espirito Santo\n" +
    "Fm     Gbm    Abm      Bbm\n" +
    "Renova minha vida...\n"
}