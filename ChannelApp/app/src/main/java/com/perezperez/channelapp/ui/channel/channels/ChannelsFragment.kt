package com.perezperez.channelapp.ui.channel.channels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.perezperez.channelapp.R
import com.perezperez.channelapp.data.model.ChannelModel
import com.perezperez.channelapp.databinding.FragmentChannelsBinding
import com.perezperez.channelapp.ui.channel.channels.recyclerview.ChannelRecyclerViewAdapter


class ChannelsFragment : Fragment() {

    private lateinit var binding: FragmentChannelsBinding
    private lateinit var adapter: ChannelRecyclerViewAdapter

    private val viewModel: ChannelViewModel by activityViewModels{
        ChannelViewModel.Factory
    }

    private lateinit var buttonAddMovie: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentChannelsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)
        bind(view)

        buttonAddMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_channelsFragment_to_newChannelFragment)
        }
    }

        private fun showSelectedItem(channel: ChannelModel) {
        viewModel.setSelectedChannel(channel)
        findNavController().navigate(R.id.action_channelsFragment_to_channelFragment3)
    }

    fun bind(view: View) {

        buttonAddMovie = view.findViewById(R.id.action_toCreat_movie)
        //nationalTeamCardView = view.findViewById(R.id.card_nationalTeam)

    }

    private fun displayChannel() {
        adapter.setData(viewModel.getChannel())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View ){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = ChannelRecyclerViewAdapter (
            clickListener = { selectedChannel ->
            showSelectedItem(selectedChannel)
        }
        )
        binding.recyclerView.adapter = adapter
        displayChannel()
    }

}