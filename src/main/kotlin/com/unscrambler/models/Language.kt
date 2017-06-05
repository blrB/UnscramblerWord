package com.unscrambler.models

enum class Language(val size: Int, val alphabet: CharArray) {

    RU(33, "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray()),
    BY(32, "абвгдеёжзійклмнопрстуўфхцчшыьэюя".toCharArray()),
    EN(26, "abcdefghiJklmnopqrstuvwxyz".toCharArray());

    fun code(): String {
        return this.name.toLowerCase()
    }

}

fun getLanguageByString(string: String): Language {
    return when (string.toLowerCase()) {
        Language.EN.code() -> Language.EN
        Language.RU.code() -> Language.RU
        Language.BY.code() -> Language.BY
        else -> {
            Language.EN
        }
    }
}
