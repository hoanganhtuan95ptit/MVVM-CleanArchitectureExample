package net.lab.myapplication.data.db

interface InterfaceDb<T : Any> {
    fun deleteAll()

    fun getAll(): List<T>

    fun insertOrUpdate(list: List<T>)
}