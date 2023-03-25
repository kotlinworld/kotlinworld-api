package ru.elerphore.kotlinworld.api.news

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.elerphore.kotlinworld.data.news.NewsEntity
import ru.elerphore.kotlinworld.data.news.NewsRepository
import ru.elerphore.kotlinworld.data.tags.TagEntity
import ru.elerphore.kotlinworld.data.tags.TagRepository
import ru.elerphore.kotlinworld.dto.NewsItem
import ru.elerphore.kotlinworld.extension.toNewsItem
import ru.elerphore.kotlinworld.extension.toTagItem

@RestController
@RequestMapping("/news")
class NewsController(
    val newsRepository: NewsRepository,
    val tagRepository: TagRepository,
) {

    @GetMapping
    fun news() =
        newsRepository.findAll()
            .map { it.toNewsItem() }
            .flatMap { newsItem ->
                tagRepository.findAllTagsByNewsId(newsItem.id)
                    .map { it.toTagItem() }
                    .collectList()
                    .map { newsItem.apply { this.tags = it } }
            }
            .collectList()

    @PostMapping
    fun addNews(newsItem: NewsItem) =
        newsRepository.save(NewsEntity(newsItem))
            .flatMap { newsEntity ->
                tagRepository.saveAll(newsItem.tags.map { TagEntity(it) }).collectList()
                    .map { newsEntity.apply { tags = it } }
            }
            .map { it.toNewsItem() }

}