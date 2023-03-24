package ru.elerphore.kotlinworld.data

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.OffsetDateTime

@Table("news")
data class NewsEntity(
    @Id
    val id: String,

    @Column
    val updateTime: OffsetDateTime,

    @Column
    val creator: String,

    @Column
    val rootUrl: String,
)
