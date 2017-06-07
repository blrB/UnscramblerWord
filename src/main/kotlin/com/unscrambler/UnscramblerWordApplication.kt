package com.unscrambler

import com.unscrambler.repositories.DictionaryRepository
import com.unscrambler.repositories.WordRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.core.task.SimpleAsyncTaskExecutor
import org.springframework.core.task.TaskExecutor

@SpringBootApplication
@EnableCaching
open class UnscramblerWordApplication(val dictionaryRepository: DictionaryRepository,
                                      val wordRepository: WordRepository) {

    @Bean
    fun taskExecutor(): TaskExecutor {
        return SimpleAsyncTaskExecutor()
    }

    @Bean
    fun init(executor: TaskExecutor) = CommandLineRunner {
        executor.execute(DictionaryLoader(dictionaryRepository, wordRepository))
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(UnscramblerWordApplication::class.java, *args)
}
