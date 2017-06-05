package com.unscrambler.services

import com.unscrambler.models.Dictionary
import com.unscrambler.models.Language

interface DictionaryService {

    fun getDictionaryByLanguage(language: Language): Dictionary

}
