package com.testtask.androiddev.data.mapper

import com.testtask.androiddev.data.db.NumberFactEntity
import com.testtask.androiddev.domain.model.NumberFact

fun NumberFactEntity.toNumberFact() = NumberFact(fact = numberFact)

fun NumberFact.toNumberFactEntity() = NumberFactEntity(numberFact = fact)