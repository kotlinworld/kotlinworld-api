package ru.elerphore.kotlinworld.extension

import ru.elerphore.kotlinworld.data.tags.TagEntity
import ru.elerphore.kotlinworld.dto.TagItem

fun TagEntity.toTagItem() = TagItem(id, name)

fun TagEntity.fromTagItem(tagItem: TagItem) = apply {
    id = tagItem.id
    name = tagItem.name
}