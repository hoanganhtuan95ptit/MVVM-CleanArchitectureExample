package net.lab.myapplication.data.db.realm

import io.realm.Realm
import io.realm.RealmModel
import net.lab.myapplication.App
import net.lab.myapplication.data.db.realm.enitities.RealmImage

open abstract class RealmDb {

    fun deleteAll(clazz: Class<RealmImage>) {
        Realm.init(App.shared)
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.where(clazz).findAll().deleteAllFromRealm()
        realm.commitTransaction()
        realm.close()
    }

    fun <T : RealmModel> getAll(clazz: Class<T>): List<T> {
        Realm.init(App.shared)
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        val results = realm.copyFromRealm(realm.where(clazz).findAll())
        realm.commitTransaction()
        realm.close()
        return results
    }

    fun <T : RealmModel> save(list: List<T>) {
        Realm.init(App.shared)
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.insertOrUpdate(list)
        realm.commitTransaction()
        realm.close()
    }

}