package com.example.membersofparlament

/*
6.3.2022
Niilo Urpola
2217663
 */
// Home fragment that contains the search bar
// The search bar is used to search for a party and the button navigates to the party fragment
// The party name is passed to the party fragment as an argument


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.membersofparlament.HomeDirections.Companion.actionNavHomeToNavParty2
import com.example.membersofparlament.databinding.FragmentHomeBinding

class Home : Fragment() {

private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textViewError.visibility = View.INVISIBLE


        binding.button.setOnClickListener{
            // jos puoluetta ei ole, näytetään virheilmoitus
            val userInput = binding.editTextInput.text.toString()
                if (userInput == "kd" || userInput == "kesk" || userInput == "kok" || userInput == "liik" || userInput == "ps" || userInput == "r" || userInput == "sd" || userInput == "vas" || userInput == "vihr" || userInput == "vkk" || userInput == "wr") {
                    findNavController().navigate(actionNavHomeToNavParty2(userInput))
                    getHomeInput(userInput)
                    Log.d("Test", "User input: $userInput")
                } else {
                    Log.d("Test", "User input: $userInput")
                    binding.textViewError.visibility = View.VISIBLE
                }
            }
        }

override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    binding = FragmentHomeBinding.inflate(inflater, container, false)
    return binding.root
}
    fun getHomeInput(HomeuserInput : String): String {
        return HomeuserInput
    }
}


