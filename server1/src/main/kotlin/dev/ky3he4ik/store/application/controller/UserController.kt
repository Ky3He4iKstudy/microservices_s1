package dev.ky3he4ik.store.application.controller

import org.springframework.web.bind.annotation.*
import dev.ky3he4ik.store.domain.entity.KeyEntity
import dev.ky3he4ik.store.domain.entity.StorageItem
import dev.ky3he4ik.store.domain.service.StorageService

@RestController
class UserController(val service: StorageService) {

    @RequestMapping("/get_data")
    fun getAll(): List<StorageItem> = service.getAll()

    @RequestMapping("/get/{key}")
    fun getByKey(@PathVariable("key") key: Int): StorageItem = service.get(key) ?: StorageItem()

    @PostMapping("/set")
    fun set(@RequestBody item: StorageItem): StorageItem = service.set(item)

    @PostMapping("/remove")
    fun removeByKey(@RequestBody key: KeyEntity): Boolean = service.delete(key.key)

    @RequestMapping("/health")
    fun health(): String = "{\"storage\": \"ok\"}"
}
