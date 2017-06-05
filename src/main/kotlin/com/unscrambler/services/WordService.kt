package com.unscrambler.services

import com.unscrambler.models.Language
import com.unscrambler.models.Word

interface WordService {

    fun findAllByTemplate(language: Language, letters: String): List<Word>

}
