package com.example.dectionaryapp.Feature_dictionary.di

import android.app.Application
import androidx.room.Room
import com.example.dectionaryapp.Feature_dictionary.data.local.Converts
import com.example.dectionaryapp.Feature_dictionary.data.local.WordInfoDao
import com.example.dectionaryapp.Feature_dictionary.data.local.WordInfoDatabase
import com.example.dectionaryapp.Feature_dictionary.data.remote.DictionaryApi
import com.example.dectionaryapp.Feature_dictionary.data.repositry.WordInfoRepostorylmpl
import com.example.dectionaryapp.Feature_dictionary.data.util.GsonParser
import com.example.dectionaryapp.Feature_dictionary.domain.repestory.WordInfoRepestory
import com.example.dectionaryapp.Feature_dictionary.domain.use_case.GetWordInfo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {
    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository : WordInfoRepestory) : GetWordInfo {
        return GetWordInfo(repository)
    }
    @Provides
    @Singleton
fun provideWordInfoRepository(

    db: WordInfoDatabase,
    api: DictionaryApi
):WordInfoRepestory{
    return WordInfoRepostorylmpl(api, db.dao)
}
    @Provides
    @Singleton
fun provideWordInfoDatabase(app : Application) : WordInfoDatabase{
    return Room.databaseBuilder(
        app,WordInfoDatabase::class.java,"word_db"
    ).addTypeConverter(Converts(GsonParser(Gson())))
        .build()
}
    @Provides
    @Singleton
fun provideDictionaryApi() : DictionaryApi{
    return Retrofit.Builder()
        .baseUrl(DictionaryApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(DictionaryApi::class.java)
}

}
