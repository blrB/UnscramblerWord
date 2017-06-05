package com.unscrambler

import com.unscrambler.models.Dictionary
import com.unscrambler.models.Language
import com.unscrambler.models.Word
import com.unscrambler.repositories.DictionaryRepository
import com.unscrambler.repositories.WordRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class UnscramblerWordApplication {

    @Bean
    fun init(dictionaryRepository: DictionaryRepository, wordRepository: WordRepository) = CommandLineRunner {
        val word = arrayListOf<Word>(
                wordRepository.save(Word("привет", Language.RU)),
                wordRepository.save(Word("мир", Language.RU))
        )
        dictionaryRepository.save(Dictionary(Language.EN))
        dictionaryRepository.save(Dictionary(Language.RU, word))
        dictionaryRepository.save(Dictionary(Language.BY))
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(UnscramblerWordApplication::class.java, *args)
}
