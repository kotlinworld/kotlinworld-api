package ru.elerphore.kotlinworld.api.hashes

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.elerphore.kotlinworld.data.hashes.HashRepository

@RestController
@RequestMapping("/hashes")
class HashController(
    val hashRepository: HashRepository,
) {

    @GetMapping
    fun hashes() = hashRepository.findAll()

}