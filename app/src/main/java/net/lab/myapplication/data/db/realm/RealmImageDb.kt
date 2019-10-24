package net.lab.myapplication.data.db.realm

import net.lab.domain.entities.ImageEntity
import net.lab.myapplication.data.db.ImageDb
import net.lab.myapplication.data.db.realm.enitities.RealmImage
import net.lab.myapplication.data.db.realm.enitities.mapper.RealmMapperProvider

class RealmImageDb : RealmDb(), ImageDb {

    override fun deleteAll() {
        deleteAll(RealmImage::class.java)
    }

    override fun getAll(): List<ImageEntity> {
        return RealmMapperProvider.realmImageMapper.mapToEntity(getAll(RealmImage::class.java))
    }

    override fun insertOrUpdate(list: List<ImageEntity>) {
        save(RealmMapperProvider.realmImageMapper.mapFromEntity(list))
    }
}