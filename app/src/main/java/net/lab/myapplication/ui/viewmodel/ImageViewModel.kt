package net.lab.myapplication.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import net.lab.domain.entities.ImageEntity
import net.lab.domain.interact.ImageInteract

class ImageViewModel(
    private val imageInteract: ImageInteract
) : ViewModel() {

    var images = MutableLiveData<List<ImageEntity>>()

    fun getImage() {
        viewModelScope.launch(Dispatchers.Main) {
            val results = async(Dispatchers.IO) {
                imageInteract.getImage()
            }
            images.value = results.await()
        }
    }
}