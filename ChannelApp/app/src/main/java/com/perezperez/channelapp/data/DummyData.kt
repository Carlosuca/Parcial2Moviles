package com.perezperez.channelapp.data

import com.perezperez.channelapp.data.model.ChannelModel

val name = "ESPN"
val content = "Deportes"

val name2 = "Fox Sport"
val content2 = "Deportes"

var channel = mutableListOf(
    ChannelModel(name, content),
    ChannelModel(name2, content2)
)
