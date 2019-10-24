package net.lab.myapplication.data.api.retrofit.entities

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class RetrofitImage {
    var id: String = ""
    var url: String = ""

    constructor()

    constructor(id: String, url: String) {
        this.id = id
        this.url = url
    }
}
