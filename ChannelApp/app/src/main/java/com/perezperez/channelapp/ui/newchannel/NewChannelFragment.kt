package com.perezperez.channelapp.ui.newchannel

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.perezperez.channelapp.R
import com.perezperez.channelapp.databinding.FragmentChannelsBinding
import com.perezperez.channelapp.databinding.FragmentNewChannelBinding
import com.perezperez.channelapp.ui.channel.channels.ChannelViewModel


class NewChannelFragment : Fragment() {

    private lateinit var binding: FragmentNewChannelBinding

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

        binding = FragmentNewChannelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }


    private fun setViewModel() {
        binding.viewmodel = viewModel
    }

    private fun observeStatus() {
        viewModel.status.observe(viewLifecycleOwner) {status ->
            when{
                status.equals(ChannelViewModel.WRONG_INFORMATION) -> {
                    Log.d("APP_TAG", status)
                    viewModel.clearStatus()
                }
                status.equals(ChannelViewModel.CHANNEL_CRATED) -> {
                    Log.d("APP_LOG", status)
                    Log.d("APP_LOG", viewModel.getChannel().toString())

                    viewModel.clearStatus()
                    findNavController().popBackStack()
                    Toast.makeText(context, "New channel adding", LENGTH_SHORT).show()

                }
            }

        }
    }



}