package net.lab.myapplication.data.db.realm.enitities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RealmImage : RealmObject {

    @PrimaryKey
    var id: String = ""
    var url: String = ""

    constructor()

    constructor(id: String, url: String) {
        this.id = id
        this.url = url
    }
}