package com.example.dectionaryapp.Feature_dictionary.domain.model

import android.health.connect.datatypes.DataOrigin
import com.example.dectionaryapp.Feature_dictionary.data.remote.dto.License
import com.example.dectionaryapp.Feature_dictionary.data.remote.dto.MeaningDto
import com.example.dectionaryapp.Feature_dictionary.data.remote.dto.PhoneticDto

data class WordInfo(
    val meanings: List<Meaning>,
    val origin:String,
    val phonetic: String,
    val word: String

)
