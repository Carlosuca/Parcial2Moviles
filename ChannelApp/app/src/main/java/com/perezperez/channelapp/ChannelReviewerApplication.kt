package com.perezperez.channelapp

import android.app.Application
import com.perezperez.channelapp.data.channel
import com.perezperez.channelapp.repositories.ChannelRepository

class ChannelReviewerApplication: Application() {
    val channelRepository: ChannelRepository by lazy {
        ChannelRepository(channel)
    }

}