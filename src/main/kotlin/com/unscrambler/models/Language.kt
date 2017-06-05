package com.unscrambler.models

enum class Language(val size : Int, val alphabet : CharArray) {

    RU(33, "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray()),
    BY(32, "абвгдеёжзійклмнопрстуўфхцчшыьэюя".toCharArray()),
    EN(26, "abcdefghiJklmnopqrstuvwxyz".toCharArray());

    fun code(): String {
        return this.name.toLowerCase()
    }

}
