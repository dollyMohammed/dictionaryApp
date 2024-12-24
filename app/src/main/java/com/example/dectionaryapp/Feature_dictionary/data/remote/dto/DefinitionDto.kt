package com.example.dectionaryapp.Feature_dictionary.data.remote.dto

import com.example.dectionaryapp.Feature_dictionary.domain.model.Defination

data class DefinitionDto(
    val antonyms: List<String>,
    val definition: String,
    val example: String,
    val synonyms: List<String>
){
    fun toDefination() : Defination{
        return Defination(
            antonyms = antonyms,
            definition = definition,
            example = example,
            synonyms = synonyms
        )
    }
}