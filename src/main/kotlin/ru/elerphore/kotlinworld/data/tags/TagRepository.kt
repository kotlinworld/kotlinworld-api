package ru.elerphore.kotlinworld.data.tags

import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface TagRepository : R2dbcRepository<TagEntity, Int> {
    @Query("select * from tags inner join tags_news tn on tn.newsId = :newsId")
    fun findAllTagsByNewsId(newsId: Int) : Flux<TagEntity>
}