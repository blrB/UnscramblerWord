package com.unscrambler.controllers

import com.unscrambler.models.Word
import com.unscrambler.models.getLanguageByString
import com.unscrambler.services.WordService
import org.springframework.web.bind.annotation.*

@RestController
class WordController(val wordService: WordService) {

    @RequestMapping(value = "{lang}/word/{letters}")
    fun getWords(@PathVariable("lang") lang: String, @PathVariable("letters") letters: String): List<Word> {
        val language = getLanguageByString(lang)
        return wordService.findAllByTemplate(language, letters)
    }
}
