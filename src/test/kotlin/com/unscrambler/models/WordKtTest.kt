package com.unscrambler.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class WordKtTest {

    @DisplayName("Test for getHashByWord")
    class GetHashByWordTest {

        @Test
        @DisplayName("русский")
        fun getHashByWordRu() {
            assertEquals(
                    Word("аааббвэююяяя", Language.RU).hash,
                    "321000000000000000000000000000123"
            )
        }

        @Test
        @DisplayName("беларуский")
        fun getHashByWordBy() {
            assertEquals(
                    Word("аааббвўэююяяя", Language.BY).hash,
                    "32100000000000000000010000000123"
            )
        }

        @Test
        @DisplayName("english")
        fun getHashByWordEn() {
            assertEquals(
                    Word("aaabbcxyyz", Language.EN).hash,
                    "32100000000000000000000121"
            )
        }
    }

    @DisplayName("Test for compareTo")
    class CompareToTest {

        @Test
        @DisplayName("DOES_NOT_MATCH")
        fun compareTo1() {
            val word1 = Word("aaabbcxyyz", Language.EN)
            val word2 = Word("aaabbcxyyzz", Language.EN)
            assertEquals(
                    word1.compareTo(word2),
                    ComparableWordHashResult.DOES_NOT_MATCH
            )
        }

        @Test
        @DisplayName("EQUIVALENTS")
        fun compareTo2() {
            val word1 = Word("aaabbcxyyz", Language.EN)
            val word2 = Word("aaabbcxyyz", Language.EN)
            assertEquals(
                    word1.compareTo(word2),
                    ComparableWordHashResult.EQUIVALENTS
            )
        }

        @Test
        @DisplayName("CONTAIN_ALL_LETTER")
        fun compareTo3() {
            val word1 = Word("aaabbcxyyz", Language.EN)
            val word2 = Word("aaabbcxyz", Language.EN)
            assertEquals(
                    word1.compareTo(word2),
                    ComparableWordHashResult.CONTAIN_ALL_LETTER
            )
        }

    }

}