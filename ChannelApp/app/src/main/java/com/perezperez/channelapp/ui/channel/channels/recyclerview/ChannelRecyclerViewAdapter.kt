package com.perezperez.channelapp.ui.channel.channels.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.perezperez.channelapp.data.model.ChannelModel
import com.perezperez.channelapp.databinding.ChannelItemBinding

class ChannelRecyclerViewAdapter (
    private val clickListener: (ChannelModel) -> Unit
): RecyclerView.Adapter<ChannelRecyclerViewHolder>() {
    private val channel = ArrayList<ChannelModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelRecyclerViewHolder {
        val binding = ChannelItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChannelRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return channel.size
    }

    override fun onBindViewHolder(holder: ChannelRecyclerViewHolder, position: Int) {
        val channel = channel[position]
        holder.bind(channel, clickListener)
    }

    fun setData(channelList: List<ChannelModel>) {
        channel.clear()
        channel.addAll(channelList)
    }
}
