package com.unscrambler.models


enum class ComparableWordHashResult(code: Int) {
    DOES_NOT_MATCH(-1),
    EQUIVALENTS(0),
    CONTAIN_ALL_LETTER(1)
}
