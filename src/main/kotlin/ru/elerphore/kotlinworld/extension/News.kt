package ru.elerphore.kotlinworld.extension

import ru.elerphore.kotlinworld.data.news.NewsEntity
import ru.elerphore.kotlinworld.data.tags.TagEntity
import ru.elerphore.kotlinworld.dto.NewsItem

fun NewsEntity.toNewsItem() = NewsItem(id, updateTime, createTime, creator, rootUrl, position, deleted, tags.map { it.toTagItem() })

fun NewsEntity.fromNewsItem(entityItem: NewsItem) = apply {
    id = entityItem.id
    updateTime = entityItem.updateTime
    createTime = entityItem.createTime
    creator = entityItem.creator
    rootUrl = entityItem.rootUrl
    position = entityItem.position
    deleted = entityItem.deleted
    tags = entityItem.tags.map { TagEntity(it) }
}