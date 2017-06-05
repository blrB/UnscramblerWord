package com.unscrambler.controllers

import com.unscrambler.models.Language
import com.unscrambler.services.WordService
import org.springframework.web.bind.annotation.*

@RestController
class WordController(val wordService: WordService) {

    @RequestMapping(value = "{lang}/word/{letters}")
    fun greeting(@PathVariable("lang") lang: String, @PathVariable("letters") letters: String): String {
        val language = getLanguage(lang)
        return wordService.findAllByTemplate(language, letters).toString()
    }

    fun getLanguage(lang: String): Language {
        return when (lang.toLowerCase()) {
            Language.EN.code() -> Language.EN
            Language.RU.code() -> Language.RU
            Language.BY.code() -> Language.BY
            else -> {
                Language.EN
            }
        }
    }

}
