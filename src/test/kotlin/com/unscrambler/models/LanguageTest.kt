package com.unscrambler.models

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class LanguageTest {

    @Test
    fun code() {
        assertEquals(Language.RU.code(), "ru")
        assertEquals(Language.EN.code(), "en")
        assertEquals(Language.BY.code(), "by")
    }

}