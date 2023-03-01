package com.example.membersofparlament

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.membersofparlament.Overview.ListViewModel
import com.example.membersofparlament.Room.Kansanedustaja
import com.example.membersofparlament.databinding.FragmentPartyBinding
import com.example.membersofparlament.databinding.ItemBinding
import com.example.membersofparlament.network.PMember

class Party : Fragment() {


    private lateinit var binding: FragmentPartyBinding
    private val viewModel : ListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPartyBinding.inflate(inflater, container, false)
        val adapter = ListAdapter()
        binding.RecyclerViewParty.adapter = adapter
        binding.RecyclerViewParty.layoutManager = LinearLayoutManager(activity)

        viewModel.LogData.observe(viewLifecycleOwner) {
            it?.let {
                adapter.setData(it)
            }
        }

        return binding.root
    }

}

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private var data = emptyList<Kansanedustaja>()

    class ViewHolder(private val binding : ItemBinding) : RecyclerView.ViewHolder(binding.root) {
    //    val listaRecyclerView: RecyclerView = itemView.findViewById(R.id.RecyclerView_Party)

        fun bind(pMember: PMember) {
            binding.party.text = pMember.party
            binding.first.text = pMember.firstname
            binding.last.text = pMember.lastname
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val binding = ItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val SingleItem = data[position]
        val pMember = PMember(
            lastname = SingleItem.lastname,
            firstname = SingleItem.firstname,
            hetekaId = SingleItem.hetekaId,
            seatNumber = SingleItem.seatNumber,
            party = SingleItem.party,
            minister = SingleItem.minister,
            pictureUrl = SingleItem.pictureUrl,
        )

        holder.bind(pMember)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(kansanedustaja: List<Kansanedustaja>) {
        this.data = kansanedustaja
        notifyDataSetChanged()
    }
}