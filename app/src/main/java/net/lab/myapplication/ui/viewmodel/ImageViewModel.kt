package net.lab.myapplication.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import net.lab.domain.entities.ImageEntity
import net.lab.domain.interact.ImageInteract
import net.lab.myapplication.data.db.local.PreferenceHelper

class ImageViewModel(
    private val imageInteract: ImageInteract,
    private val prefHelper: PreferenceHelper
    ) : ViewModel() {

    internal var images = prefHelper.getListImage()

    fun getImage() {
        viewModelScope.launch(Dispatchers.Main) {
            val results = async(Dispatchers.IO) {
                imageInteract.sync()
                imageInteract.getImage()
            }

            images.value = results.await()
        }
    }
}