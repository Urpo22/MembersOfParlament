
package com.example.membersofparlament

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

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
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
            // vaihtoehdot kd, kesk, kok, liik, ps, r , sd, vas, vihr, vkk, wr
            // jos puoluetta ei ole, näytetään virheilmoitus
            val userInput = binding.editTextInput.text.toString()
                if (userInput == "kd" || userInput == "kesk" || userInput == "kok" || userInput == "liik" || userInput == "ps" || userInput == "r" || userInput == "sd" || userInput == "vas" || userInput == "vihr" || userInput == "vkk" || userInput == "wr") {
            //      if (userInput.equals("kd") || userInput.equals("kesk") || userInput.equals("kok") || userInput.equals("liik") || userInput.equals("ps") || userInput.equals("r") || userInput.equals("sd") || userInput.equals("vas") || userInput.equals("vihr") || userInput.equals("vkk") || userInput.equals("wr")) {
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
    // Inflate the layout for this fragment
    binding = FragmentHomeBinding.inflate(inflater, container, false)

    return binding.root
}
    fun getHomeInput(HomeuserInput : String): String {
        return HomeuserInput
    }
}


