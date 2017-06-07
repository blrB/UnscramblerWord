package com.unscrambler.repositories

import com.unscrambler.models.Dictionary
import com.unscrambler.models.Language
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DictionaryRepository : CrudRepository<Dictionary, Long> {

    @Cacheable(value = "dictionary",  unless = "#result.size() == 0")
    fun findByLanguage(language: Language): List<Dictionary>

}
