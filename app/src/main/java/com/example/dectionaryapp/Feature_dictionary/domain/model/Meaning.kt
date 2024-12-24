package com.example.dectionaryapp.Feature_dictionary.domain.model

import com.example.dectionaryapp.Feature_dictionary.data.remote.dto.DefinitionDto

data class Meaning(
    val definations:List<Defination>,
    val partofSpeech:String
){
}
