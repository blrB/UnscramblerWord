package com.unscrambler.models

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "words")
data class Word(var string: String = "", val lang: Language = Language.EN,
                @Id @JsonIgnore @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = 0) : HashWord {
    init {
        string = string.toLowerCase()
    }

    val size = string.length

    @JsonIgnore
    val hash = getHashByWord()

    @JsonIgnore
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
