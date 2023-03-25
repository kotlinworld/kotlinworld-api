package ru.elerphore.kotlinworld.data.news

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import ru.elerphore.kotlinworld.data.tags.TagEntity
import ru.elerphore.kotlinworld.dto.NewsItem
import java.time.OffsetDateTime

@Table("news")
data class NewsEntity(
    @Id
    var id: Int,

    @Column
    var updateTime: OffsetDateTime = OffsetDateTime.now(),

    @Column
    var createTime: OffsetDateTime = OffsetDateTime.now(),

    @Column
    var creator: String,

    @Column
    var rootUrl: String,

    @Column
    var position: Int,

    @Column
    var deleted: Boolean,

    @Transient
    var tags: List<TagEntity> = emptyList()

) {
    constructor(newsItem: NewsItem) : this(
        id = newsItem.id,
        updateTime = newsItem.updateTime,
        createTime = newsItem.createTime,
        creator = newsItem.creator,
        rootUrl = newsItem.rootUrl,
        position = newsItem.position,
        deleted = newsItem.deleted,
        tags = newsItem.tags.map { TagEntity(it) },
    )
}
