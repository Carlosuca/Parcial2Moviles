package com.perezperez.channelapp.ui.channel.channels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.perezperez.channelapp.ChannelReviewerApplication
import com.perezperez.channelapp.data.model.ChannelModel
import com.perezperez.channelapp.repositories.ChannelRepository

class ChannelViewModel(private val repository: ChannelRepository): ViewModel() {

    var name = MutableLiveData("")
    var content = MutableLiveData("")
    var status = MutableLiveData("")

    fun createChannel() {
        if(!validateData()){
            status.value = WRONG_INFORMATION
            return
        }

        val channel = ChannelModel(
            name.value!!,
            content.value!!,

        )

        addChannel(channel)
        clearData()

        status.value = CHANNEL_CRATED
    }

    private fun clearData() {
        name.value = ""
        content.value = ""
    }

    fun clearStatus(){
        status.value = INACTIVE
    }


    private fun validateData(): Boolean {
        when{
            name.value.isNullOrEmpty() -> return false
            content.value.isNullOrEmpty() -> return false
            }
        return true
    }

    fun setSelectedChannel(channel: ChannelModel) {
        name.value = channel.name
        content.value = channel.content
    }



    fun getChannel() = repository.getChannels()

    fun addChannel(channel: ChannelModel) = repository.addChannels(channel)

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as ChannelReviewerApplication
                ChannelViewModel(app.channelRepository)
            }
        }
        const val CHANNEL_CRATED = "Channel Created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }


}