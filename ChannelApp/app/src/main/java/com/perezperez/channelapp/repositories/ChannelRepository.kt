package com.perezperez.channelapp.repositories

import com.perezperez.channelapp.data.model.ChannelModel

class ChannelRepository(private val channels: MutableList<ChannelModel>) {

    fun getChannels() = channels

    fun addChannels(channel: ChannelModel) = channels.add(channel)

    
}