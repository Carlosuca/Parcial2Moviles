package com.perezperez.channelapp.ui.channel.channels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.perezperez.channelapp.R
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

        return inflater.inflate(R.layout.fragment_channels, container, false)
    }

        private fun showSelectedItem(channel: ChannelViewModel) {
        viewModel.setSelectedChannel(channel)
        findNavController().navigate(R.id.action_channelsFragment_to_channelFragment3)
    }

    private fun displaChannel() {
        adapter.setData(viewModel.getChannel())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View ){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = ChannelRecyclerViewAdapter { selectedChannel ->
            showSelectedItem(selectedChannel)
        }
        binding.recyclerView.adapter = adapter
        displaChannel()
    }

}