package dev.ky3he4ik.store.domain.service

import org.springframework.stereotype.Service
import dev.ky3he4ik.store.domain.base.BaseService
import dev.ky3he4ik.store.domain.entity.StorageItem
import dev.ky3he4ik.store.infrastructure.repository.StorageRepo

@Service
class StorageService(repo: StorageRepo) : BaseService<StorageItem, Int>(repo)
