package com.unscrambler

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class UnscramblerWordApplication

fun main(args: Array<String>) {
    SpringApplication.run(UnscramblerWordApplication::class.java, *args)
}
