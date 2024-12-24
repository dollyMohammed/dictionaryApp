package com.example.dectionaryapp.Feature_dictionary.presentation

import com.example.dectionaryapp.Feature_dictionary.domain.model.WordInfo
import com.example.dectionaryapp.core.util.Resource

data class WordInfoState(
    val wordInfoIItems : List<WordInfo> = emptyList(),
    val isLoading: Boolean=false
)
