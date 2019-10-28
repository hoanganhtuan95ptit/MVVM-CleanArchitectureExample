package net.lab.myapplication.ui.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.lab.myapplication.ui.viewmodel.ImageViewModel
import net.lab.domain.interact.ImageInteract
import net.lab.myapplication.data.db.local.PreferenceHelper

class ImageViewModelFactory(
    private val imageInteract: ImageInteract,
    private val prefHelper: PreferenceHelper
    ) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ImageViewModel(imageInteract, prefHelper) as T
    }
}