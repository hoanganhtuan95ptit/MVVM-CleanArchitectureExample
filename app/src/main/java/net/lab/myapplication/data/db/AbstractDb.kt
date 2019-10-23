package net.lab.myapplication.data.db

import net.lab.myapplication.data.db.LocalResult.LocalResultNotification.Companion.notification

abstract class AbstractDb<T : Any> : InterfaceDb<T> {
    final override fun insertOrUpdate(t: List<T>) {
        handleInsertOrUpdate(t)
        notification(t)
    }

    final override fun insertOrUpdate(t: T) {
        handleInsertOrUpdate(t)
        notification(t)
    }

    final override fun delete(t: List<T>) {
        handleDelete(t)
        notification(t)
    }

    final override fun delete(t: T) {
        handleDelete(t)
        notification(t)
    }

    protected abstract fun handleInsertOrUpdate(t: T)

    protected abstract fun handleInsertOrUpdate(t: List<T>)

    protected abstract fun handleDelete(t: T)

    protected abstract fun handleDelete(t: List<T>)
}