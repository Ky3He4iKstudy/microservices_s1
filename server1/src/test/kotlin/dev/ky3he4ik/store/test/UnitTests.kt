package dev.ky3he4ik.store.test

import dev.ky3he4ik.store.CommonApplication
import dev.ky3he4ik.store.application.controller.UserController
import dev.ky3he4ik.store.domain.entity.StorageItem
import dev.ky3he4ik.store.domain.service.StorageService
import org.junit.Assert
import org.junit.Test
import org.junit.jupiter.api.Disabled
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = [CommonApplication::class])
@TestPropertySource(locations = ["classpath:application-test.properties"])
class UnitTests {
    @Autowired
    lateinit var testService: StorageService

    @Autowired
    lateinit var testController: UserController

    @Test
    fun smoke() {
        Assert.assertEquals("{\"non storage\": \"fail\"}", testController.health())
    }

    @Test
    fun addAndCheck() {
        testService.set(StorageItem(153, "value"))
        Assert.assertEquals(StorageItem(153, "value"), testService.get(153))
        Assert.assertEquals(listOf(StorageItem(153, "value")), testService.getAll())
    }

    @Test
    fun rewrite() {
        testService.set(StorageItem(153, "old value"))
        testService.set(StorageItem(153, "new value"))
        Assert.assertEquals(StorageItem(153, "new value"), testService.get(153))
    }

    @Test
    fun delete() {
        testService.set(StorageItem(153, "value"))
        testService.delete(153)
        Assert.assertEquals(listOf<StorageItem>(), testService.getAll())
    }
}
