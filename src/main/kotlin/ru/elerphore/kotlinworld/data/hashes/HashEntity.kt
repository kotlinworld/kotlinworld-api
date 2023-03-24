package ru.elerphore.kotlinworld.data

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("hashes")
data class HashEntity(
    @Id
    val id: Long,
)
