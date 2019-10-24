package net.lab.myapplication.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import net.lab.domain.interact.ImageInteract
import net.lab.myapplication.data.entities.Image
import net.lab.myapplication.data.entities.mapper.EntityMapperProvider

class ImageViewModel(
    private val imageInteract: ImageInteract
) : ViewModel() {

    var images = MutableLiveData<List<Image>>()

    fun getImage() {
        viewModelScope.launch(Dispatchers.Main) {
            val results = async(Dispatchers.IO) {
                EntityMapperProvider.mapperImageEntityImage.mapFromEntity(imageInteract.getImage())
            }

            images.value = results.await()
        }
    }
}