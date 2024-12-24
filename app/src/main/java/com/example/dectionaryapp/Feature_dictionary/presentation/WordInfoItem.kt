package com.example.dectionaryapp.Feature_dictionary.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dectionaryapp.Feature_dictionary.domain.model.WordInfo
import java.lang.reflect.Modifier

@Composable
fun WordInfoItem(
    wordInfo: WordInfo,
    modifier: androidx.compose.ui.Modifier
){
    Column(modifier = modifier) {
        Text(text = wordInfo.word,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black)
        Text(text = wordInfo.phonetic, fontWeight = FontWeight.Light)
        Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
        Text(text = wordInfo.origin)
        wordInfo.meanings.forEach {meaning ->
        Text(text = meaning.partofSpeech, fontWeight = FontWeight.Bold)
        meaning.definations.forEachIndexed { i, defination ->
            Text(text = "${i + 1}.${defination.definition}")
            Spacer(modifier = androidx.compose.ui.Modifier.height(8.dp))
            defination.example?.let {example ->
            Text(text = "Example: $example")

            }
            Spacer(modifier = androidx.compose.ui.Modifier.height(8.dp))
        }
            Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))

        }



    }

}