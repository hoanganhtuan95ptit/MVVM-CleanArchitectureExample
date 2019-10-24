package net.lab.myapplication.ui.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.lab.myapplication.ui.viewmodel.ImageViewModel
import net.lab.domain.interact.ImageInteract

class ImageViewModelFactory(
    private val imageInteract: ImageInteract
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ImageViewModel(imageInteract) as T
    }
}