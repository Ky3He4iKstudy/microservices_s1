package dev.ky3he4ik.store.infrastructure.repository

import dev.ky3he4ik.store.domain.entity.StorageItem
import org.springframework.data.jpa.repository.JpaRepository

interface StorageRepo : JpaRepository<StorageItem, Int>
