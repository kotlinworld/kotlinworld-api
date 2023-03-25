package ru.elerphore.kotlinworld.data.tags

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import ru.elerphore.kotlinworld.dto.TagItem

@Table("tags")
data class TagEntity(

    @Id
    var id: Int,

    @Column
    var name: String,

) {
    constructor(tagItem: TagItem) : this(
        id = tagItem.id,
        name = tagItem.name
    )
}
