package com.unscrambler

import com.unscrambler.models.Dictionary
import com.unscrambler.models.Language
import com.unscrambler.models.Word
import com.unscrambler.repositories.DictionaryRepository
import com.unscrambler.repositories.WordRepository
import org.slf4j.LoggerFactory
import org.springframework.core.io.ClassPathResource
import java.io.BufferedReader
import java.io.InputStreamReader

class DictionaryLoader(val dictionaryRepository: DictionaryRepository,
                       val wordRepository: WordRepository,
                       val lang : Array<Language> = Language.values()) : Runnable {

    private val log = LoggerFactory.getLogger(DictionaryLoader::class.java)

    override fun run() {
        log.info("Read dictionaries. Please wait...")
        lang.forEach { addWordAndCreateDictionary(it) }
    }

    private fun addWordAndCreateDictionary(lang: Language) {
        val resource = ClassPathResource(path(lang))
        val reader = BufferedReader(InputStreamReader(resource.inputStream))
        val words = arrayListOf<Word>()
        log.info("Read $lang dictionary")
        reader.forEachLine { words.add(wordRepository.save(Word(it, lang))) }
        dictionaryRepository.save(Dictionary(lang, words))
        log.info("In $lang dictionary add ${words.size} word")
    }

    fun path(lang: Language) = "dictionary/${lang.code()}.txt"

}