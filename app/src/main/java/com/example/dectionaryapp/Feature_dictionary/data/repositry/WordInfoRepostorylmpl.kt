package com.example.dectionaryapp.Feature_dictionary.data.repositry

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.dectionaryapp.Feature_dictionary.data.local.WordInfoDao
import com.example.dectionaryapp.Feature_dictionary.data.remote.DictionaryApi
import com.example.dectionaryapp.Feature_dictionary.domain.model.WordInfo
import com.example.dectionaryapp.Feature_dictionary.domain.repestory.WordInfoRepestory
import com.example.dectionaryapp.core.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class WordInfoRepostorylmpl(
    private val api:DictionaryApi,
    private val dao: WordInfoDao
): WordInfoRepestory {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow{
        emit(Resource.Loading())
        val wordInfos=dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Loading(data =wordInfos))
        try {
            val remoteWordinfos= api.getWordInfo(word)
            dao.deleteWordInfos(remoteWordinfos.map { it.word })
            dao.insertWordInfos(remoteWordinfos.map { it.toWordInfoEntity() })
        }catch (e:HttpException){
            emit(Resource.Error(
                message = "Oops,something went wrong",
                data = wordInfos
            ))

        }catch (e:IOException){
            emit(Resource.Error(
                message = "Could not reach server ,check your internet connection.",
                data = wordInfos
            ))


        }
        val newWordInfos=dao.getWordInfos( word ).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfos))
    }



}