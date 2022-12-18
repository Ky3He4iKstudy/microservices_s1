import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    id("org.springframework.boot") version "2.7.5" apply false
    id("io.spring.dependency-management") version "1.0.8.RELEASE" apply false
    kotlin("jvm") version "1.7.21" apply false
    kotlin("plugin.spring") version "1.7.21" apply false
}

allprojects {
    group = "dev.ky3he4ik"
    version = "1.0.0"

    tasks.withType<JavaCompile> {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
            incremental = false
        }
    }
}

val bootableServices = listOf("server1")

subprojects {
    repositories {
        mavenCentral()
    }

    apply {
        plugin("io.spring.dependency-management")
    }

    val boot = bootableServices.contains(this.name)

    tasks.withType<Jar> {
        enabled = false
    }
    tasks.withType<BootJar> {
        enabled = boot
        
    }
}
