package com.example.dectionaryapp.Feature_dictionary.domain.repestory

import com.example.dectionaryapp.Feature_dictionary.domain.model.WordInfo
import com.example.dectionaryapp.core.util.Resource
import kotlinx.coroutines.flow.Flow

interface WordInfoRepestory {

    fun getWordInfo(word:String) : Flow<Resource<List<WordInfo>>>
}