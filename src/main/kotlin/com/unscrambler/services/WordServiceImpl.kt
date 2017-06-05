package com.unscrambler.services

import com.unscrambler.models.Language
import com.unscrambler.models.Word
import org.springframework.stereotype.Service

@Service
class WordServiceImpl(val dictionaryService: DictionaryService) : WordService {

    override fun findAllByTemplate(language: Language, letters: String): List<Word> {
        println("Lang: $language, letter: $letters")
        val dictionary = dictionaryService.getDictionaryByLanguage(language)
        println(dictionary.toString())
        return dictionary.words
    }

}
