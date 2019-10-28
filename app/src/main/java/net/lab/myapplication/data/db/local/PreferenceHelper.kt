package net.lab.myapplication.data.db.local

import android.content.Context
import androidx.lifecycle.MutableLiveData
import net.lab.domain.entities.ImageEntity

class PreferenceHelper constructor(context: Context) {
    private var listImageLD = MutableLiveData<List<ImageEntity>>()

    fun getListImage() : MutableLiveData<List<ImageEntity>>{
        return listImageLD
    }
}