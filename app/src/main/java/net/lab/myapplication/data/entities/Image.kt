package net.lab.myapplication.data.entities

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class Image {
    var id: String = ""
    var url: String = ""

    constructor()

    constructor(id: String, url: String) {
        this.id = id
        this.url = url
    }
}
