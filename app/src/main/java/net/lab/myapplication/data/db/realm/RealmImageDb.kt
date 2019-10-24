package net.lab.myapplication.data.db.realm

import net.lab.myapplication.data.db.ImageDb
import net.lab.myapplication.data.db.realm.enitities.RealmImage
import net.lab.myapplication.data.db.realm.enitities.mapper.RealmMapperProvider
import net.lab.myapplication.data.entities.Image

class RealmImageDb : RealmDb(), ImageDb {

    override fun deleteAll() {
        deleteAll(RealmImage::class.java)
    }

    override fun getAll(): List<Image> {
        return RealmMapperProvider.realmImageMapper.mapFromEntity(getAll(RealmImage::class.java))
    }

    override fun insertOrUpdate(list: List<Image>) {
        save(RealmMapperProvider.realmImageMapper.mapToEntity(list))
    }
}