package com.example.dectionaryapp.Feature_dictionary.data.remote.dto

import com.example.dectionaryapp.Feature_dictionary.domain.model.Meaning

data class MeaningDto(
    val antonyms: List<Any>,
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String,
    val synonyms: List<String>
){
    fun toMeaning(): Meaning {
        return Meaning(
            definations = definitions.map { it.toDefination() },
            partofSpeech=partOfSpeech
        )
    }

}