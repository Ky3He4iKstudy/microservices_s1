package dev.ky3he4ik.store.domain.base

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull

abstract class BaseService<E : Any, ID>(private val repo: JpaRepository<E, ID>) {
    open fun getAll(): List<E> = repo.findAll().toList()

    open fun get(id: ID): E? =
        repo.findByIdOrNull(id)

    open fun set(e: E): E {
        return repo.save(e)
    }

    open fun delete(id: ID): Boolean {
        val entity = repo.findByIdOrNull(id) ?: return false
        repo.delete(entity)
        return true
    }
}