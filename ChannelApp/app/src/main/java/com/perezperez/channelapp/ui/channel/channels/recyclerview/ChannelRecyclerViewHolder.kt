package com.perezperez.channelapp.ui.channel.channels.recyclerview

import androidx.recyclerview.widget.RecyclerView

import com.perezperez.channelapp.data.model.ChannelModel
import com.perezperez.channelapp.databinding.ChannelItemBinding

class ChannelRecyclerViewHolder(private val binding: ChannelItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(channel: ChannelModel, clickListener: (ChannelModel) -> Unit) {
        binding.nameTeamTextView.text = channel.name
        binding.rankingTeamTextView.text = channel.content

        binding.cardNationalTeam.setOnClickListener {
            clickListener(channel)
        }
    }



}