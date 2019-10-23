package net.lab.myapplication.data.db.realm.enitities

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.realm.annotations.PrimaryKey
import net.lab.myapplication.data.entities.Image

@JsonInclude(JsonInclude.Include.NON_NULL)
class RealmImage : Image {

    @PrimaryKey
    @JsonProperty("id")
    var idRealm: String = ""

    @JsonProperty("url")
    var urlRealm: String = ""

    override fun getId(): String {
        return idRealm
    }

    override fun getUrl(): String {
        return urlRealm
    }
}