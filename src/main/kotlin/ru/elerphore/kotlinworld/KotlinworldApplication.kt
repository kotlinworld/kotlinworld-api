package ru.elerphore.kotlinworld

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinworldApplication

fun main(args: Array<String>) {
	runApplication<KotlinworldApplication>(*args)
}
