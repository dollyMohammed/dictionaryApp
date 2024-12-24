package com.example.dectionaryapp.Feature_dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.dectionaryapp.Feature_dictionary.data.util.GsonParser
import com.example.dectionaryapp.Feature_dictionary.data.util.JsonParser
import com.example.dectionaryapp.Feature_dictionary.domain.model.Meaning
import com.google.gson.reflect.TypeToken
@ProvidedTypeConverter
class Converts(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromMeaningJson(json:String):List<Meaning> {
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object :TypeToken<ArrayList<Meaning>>(){}.type
        ) ?: emptyList()
    }
    @TypeConverter
    fun toMeaningsJson(meanings:List<Meaning>) :String{
        return jsonParser.toJson(
            meanings,
            object :TypeToken<ArrayList<Meaning>>(){}.type
        ) ?: "[]"
    }
}