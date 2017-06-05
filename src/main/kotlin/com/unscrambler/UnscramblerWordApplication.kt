package com.unscrambler

import com.unscrambler.models.Dictionary
import com.unscrambler.models.Language
import com.unscrambler.models.Word
import com.unscrambler.repositories.DictionaryRepository
import com.unscrambler.repositories.WordRepository
import com.unscrambler.services.WordServiceImpl
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import java.io.File

@SpringBootApplication
@EnableCaching
open class UnscramblerWordApplication(val dictionaryRepository: DictionaryRepository,
                                      val wordRepository: WordRepository) {

    private val log = LoggerFactory.getLogger(WordServiceImpl::class.java)

    @Bean
    fun init() = CommandLineRunner {
        val lang = Language.values()
        log.info("Read dictionaries. Please wait...")
        lang.forEach { addWordAndCreateDictionary(it) }
    }

    private fun addWordAndCreateDictionary(lang: Language) {
        val file = File(path(lang))
        val words = arrayListOf<Word>()
        log.info("Read $lang dictionary")
        file.forEachLine { words.add(wordRepository.save(Word(it, lang))) }
        dictionaryRepository.save(Dictionary(lang, words))
        log.info("In $lang dictionary add ${words.size} word")
    }

    fun path(lang: Language) = "src/main/resources/dictionary/${lang.code()}.txt"

}

fun main(args: Array<String>) {
    SpringApplication.run(UnscramblerWordApplication::class.java, *args)
}
