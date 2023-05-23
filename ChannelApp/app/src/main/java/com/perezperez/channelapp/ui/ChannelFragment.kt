package com.perezperez.channelapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.perezperez.channelapp.R
import com.perezperez.channelapp.databinding.FragmentChannelBinding
import com.perezperez.channelapp.ui.channel.channels.ChannelViewModel


class ChannelFragment : Fragment() {

    private lateinit var binding: FragmentChannelBinding
    private val viewModel: ChannelViewModel by activityViewModels{
        ChannelViewModel.Factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_channel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}