package com.unscrambler.services

import com.unscrambler.models.Dictionary
import com.unscrambler.models.Language
import com.unscrambler.repositories.DictionaryRepository
import org.springframework.stereotype.Service

@Service
class DictionaryServiceImpl(val dictionaryRepository: DictionaryRepository) : DictionaryService {

    override fun getDictionaryByLanguage(language: Language): Dictionary {
        return dictionaryRepository.findByLanguage(language).first()
    }

}
