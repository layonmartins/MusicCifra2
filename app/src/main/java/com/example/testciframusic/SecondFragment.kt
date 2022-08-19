package com.example.testciframusic

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.testciframusic.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private var music : String? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        music = arguments?.getString("music")
        Log.d("layon.f", "music = \n$music")

        findCiphersApproatch1()

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    //TODO this function that receives a TextView
    // that find and print all ciphers
    // ex: Em, D and G in sequence
    private fun findCiphersApproatch1(){
        music?.let{
            binding.textviewSecond.setStyleOnSubstring(
                string = it,
                substring = Note.D.cipher,
                style = R.style.Theme_TestCifraMusic_Cipher)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}