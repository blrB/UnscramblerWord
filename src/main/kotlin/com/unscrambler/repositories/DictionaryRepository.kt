package com.unscrambler.repositories

import com.unscrambler.models.Dictionary
import com.unscrambler.models.Language
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DictionaryRepository : CrudRepository<Dictionary, Long> {

    fun findByLanguage(language: Language): List<Dictionary>

}
