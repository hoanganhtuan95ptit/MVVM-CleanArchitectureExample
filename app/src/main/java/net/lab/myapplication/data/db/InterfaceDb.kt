package net.lab.myapplication.data.db

interface InterfaceDb<T : Any> {

    fun getAll(clazz: Class<T>): List<T>

    fun getListBy(
        field: String,
        data: Int,
        clazz: Class<T>
    ): List<T>

    fun getListBy(
        field: String,
        data: Long,
        clazz: Class<T>
    ): List<T>

    fun getListBy(
        field: String,
        data: Float,
        clazz: Class<T>
    ): List<T>

    fun getListBy(
        field: String,
        data: Double,
        clazz: Class<T>
    ): List<T>

    fun getListBy(
        field: String,
        data: String,
        clazz: Class<T>
    ): List<T>

    fun getListBy(
        field: String,
        data: Boolean,
        clazz: Class<T>
    ): List<T>

    fun getBy(
        field: String,
        data: Int,
        clazz: Class<T>
    ): T

    fun getBy(
        field: String,
        data: Long,
        clazz: Class<T>
    ): T

    fun getBy(
        field: String,
        data: Float,
        clazz: Class<T>
    ): T

    fun getBy(
        field: String,
        data: Double,
        clazz: Class<T>
    ): T

    fun getBy(
        field: String,
        data: String,
        clazz: Class<T>
    ): T

    fun getBy(
        field: String,
        data: Boolean,
        clazz: Class<T>
    ): T

    fun insertOrUpdate(t: T)

    fun insertOrUpdate(t: List<T>)

    fun delete(t: T)

    fun delete(t: List<T>)
}