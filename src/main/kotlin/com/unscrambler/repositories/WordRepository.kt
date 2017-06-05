package com.unscrambler.repositories

import com.unscrambler.models.Word

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WordRepository : CrudRepository<Word, Long>
