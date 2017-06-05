package com.unscrambler.services

import com.unscrambler.models.ComparableWordHashResult
import com.unscrambler.models.Language
import com.unscrambler.models.Word
import org.springframework.stereotype.Service

@Service
class WordServiceImpl(val dictionaryService: DictionaryService) : WordService {

    override fun findAllByTemplate(language: Language, letters: String): List<Word> {
        val dictionary = dictionaryService.getDictionaryByLanguage(language)
        val word = Word(letters, language)
        var words = dictionary.words.filter { word.compareTo(it) != ComparableWordHashResult.DOES_NOT_MATCH }
        words = words.sortedByDescending { it.size }
        return words
    }

}
