package net.lab.myapplication.data.db.realm

import net.lab.myapplication.data.db.AbstractDb

open class RealmDb<T:Any> : AbstractDb<T>() {
    override fun handleInsertOrUpdate(t: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleInsertOrUpdate(t: List<T>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleDelete(t: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleDelete(t: List<T>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAll(clazz: Class<T>): List<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListBy(field: String, data: Int, clazz: Class<T>): List<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListBy(field: String, data: Long, clazz: Class<T>): List<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListBy(field: String, data: Float, clazz: Class<T>): List<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListBy(field: String, data: Double, clazz: Class<T>): List<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListBy(field: String, data: String, clazz: Class<T>): List<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListBy(field: String, data: Boolean, clazz: Class<T>): List<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBy(field: String, data: Int, clazz: Class<T>): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBy(field: String, data: Long, clazz: Class<T>): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBy(field: String, data: Float, clazz: Class<T>): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBy(field: String, data: Double, clazz: Class<T>): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBy(field: String, data: String, clazz: Class<T>): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBy(field: String, data: Boolean, clazz: Class<T>): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}