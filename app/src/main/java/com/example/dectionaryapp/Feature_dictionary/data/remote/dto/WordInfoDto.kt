package com.example.dectionaryapp.Feature_dictionary.data.remote.dto

import com.example.dectionaryapp.Feature_dictionary.data.local.entry.WordInfoEntity
import com.example.dectionaryapp.Feature_dictionary.domain.model.Meaning
import com.example.dectionaryapp.Feature_dictionary.domain.model.WordInfo

data class WordInfoDto(
    val license: License,
    val meanings: List<MeaningDto>,
    val origin:String,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val sourceUrls: List<String>,
    val word: String
){
    fun toWordInfoEntity(): WordInfoEntity{
        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            origin = origin,
            phonetic = phonetic,
            word = word
        )
    }

}