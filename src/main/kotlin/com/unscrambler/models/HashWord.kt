package com.unscrambler.models

interface HashWord {

    fun getHashByWord(): String

    fun compareTo(other: Word): ComparableWordHashResult

}
