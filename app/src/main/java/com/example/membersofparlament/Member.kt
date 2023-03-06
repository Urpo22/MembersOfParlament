package com.example.membersofparlament

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import coil.load
import coil.request.ImageRequest
import com.example.membersofparlament.Overview.ListViewModel
import com.example.membersofparlament.Room.Kansanedustaja
import com.example.membersofparlament.databinding.FragmentMemberBinding
import com.example.membersofparlament.databinding.FragmentPartyBinding
import com.example.membersofparlament.network.PMember

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [Member.newInstance] factory method to
 * create an instance of this fragment.
 */
class Member : Fragment() {

    private lateinit var binding: FragmentMemberBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("SetTextI18n")
    // suppress warning for textviewNimi.text
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args = MemberArgs.fromBundle(requireArguments())
        Log.d ("Test", "Member Fragment: ${args.member}")

        // Inflate the layout for this fragment
        binding = FragmentMemberBinding.inflate(inflater, container, false)

        binding.imageView.load("https://avoindata.eduskunta.fi/" + args.member.pictureUrl) {
            crossfade(true)
        }

        binding.textViewNimi.text = args.member.firstname + " " + args.member.lastname
        binding.textViewSeat.text = args.member.seatNumber.toString()
        binding.textViewPuolue.text = args.member.party
        binding.textViewMinister.text = args.member.minister.toString()
        if (args.member.minister == true) {
            binding.textViewMinister.text = "Ministeri: Kyllä"
        } else {
            binding.textViewMinister.text = "Ministeri: Ei"
        }
        binding.textViewHeteka.text = args.member.hetekaId.toString()

        binding.textViewBornYear.text = args.member.bornYear.toString()

        if (args.member.constituency == null) {
            binding.textViewconstituency.text = "Ei tiedossa"
        } else {
            binding.textViewconstituency.text = args.member.constituency
        }

        if (args.member.twitter == null) {
            binding.textViewtwitter.text = "Ei tiedossa"
        } else {
            binding.textViewtwitter.text = args.member.twitter
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            Member().apply {

                }
            }
    }
