package ru.elerphore.kotlinworld.dto

import java.time.OffsetDateTime

data class NewsItem(
    val id: Int,
    val updateTime: OffsetDateTime,
    val createTime: OffsetDateTime,
    val creator: String,
    val rootUrl: String,
    val position: Int,
    val deleted: Boolean,
    var tags: List<TagItem> = emptyList()
)
