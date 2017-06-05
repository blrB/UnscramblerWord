package com.unscrambler.models

import javax.persistence.*

@Entity
@Table(name = "dictionaries")
class Dictionary(var language: Language = Language.EN, @OneToMany var words: List<Word> = ArrayList(),
                 @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = 0)
