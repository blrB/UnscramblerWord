package com.unscrambler.models

import javax.persistence.*

@Entity
@Table(name = "words")
data class Word(val string: String = "", val lang: Language = Language.EN,
                @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = 0) : HashWord {

    val hash = getHashByWord()

    override fun getHashByWord(): String {
        val alphabet = lang.alphabet
        var hash = ""
        alphabet.forEach { char -> hash += string.count { it == char } }
        return hash
    }

    override fun compareTo(other: Word): ComparableWordHashResult {
        return if (this.lang != other.lang) {
            ComparableWordHashResult.DOES_NOT_MATCH
        } else if (this.hash == other.hash) {
            ComparableWordHashResult.EQUIVALENTS
        } else {
            this.hash.forEachIndexed { index, char ->
                if (char < other.hash[index]) {
                    return ComparableWordHashResult.DOES_NOT_MATCH
                }
            }
            ComparableWordHashResult.CONTAIN_ALL_LETTER
        }
    }

}
