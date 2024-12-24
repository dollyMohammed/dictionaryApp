package com.example.dectionaryapp.Feature_dictionary.domain.use_case

import com.example.dectionaryapp.Feature_dictionary.domain.model.WordInfo
import com.example.dectionaryapp.Feature_dictionary.domain.repestory.WordInfoRepestory
import com.example.dectionaryapp.core.util.Resource
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow


class GetWordInfo(
    private val repostory:WordInfoRepestory
) {
    operator fun invoke(word : String): Flow<Resource<List<WordInfo>>>{
        if (word.isBlank()){
            return flow {  }

        }
        return repostory.getWordInfo(word)
    }
}