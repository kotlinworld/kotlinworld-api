package ru.elerphore.kotlinworld.data.news

import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository

@Repository
interface NewsRepository : R2dbcRepository<NewsEntity, Long>