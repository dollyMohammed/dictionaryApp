package com.example.dectionaryapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.TextField
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dectionaryapp.Feature_dictionary.presentation.WordInfoItem
import com.example.dectionaryapp.Feature_dictionary.presentation.WordInfoViewModel
import com.example.dectionaryapp.ui.theme.DectionaryAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DectionaryAppTheme {
                val viewModel:WordInfoViewModel = hiltViewModel()
                val state=viewModel.state.value
                val scaffoldState= rememberScaffoldState()

                LaunchedEffect(key1 = true){
                    viewModel.eventFlow.collectLatest { event ->
                    when(event) {
                        is WordInfoViewModel.UIEvent.ShowSnackbar -> {
                            scaffoldState.snackbarHostState.showSnackbar(
                                message = event.message
                            )

                        }
                    }

                    }
                }
                Scaffold (
                   // scaffoldState= scaffoldState
                ){
                    Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)){
                        Column (modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)){
                            TextField(value = viewModel.searchQuery.value,
                                onValueChange = viewModel::onSearch,
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(text = "Search...")
                                })
                            Spacer(modifier = Modifier.height(16.dp))
                            LazyColumn(modifier = Modifier.fillMaxSize()){
                                items(state.wordInfoIItems.size){i->
                                    val wordInfo=state.wordInfoIItems[i]
                                    if(i> 0){
                                        Spacer(modifier = Modifier.height(8.dp))
                                    }
                                    WordInfoItem(wordInfo=wordInfo,
                                        modifier = Modifier)
                                    if(i < state.wordInfoIItems.size -1){
                                        Divider()
                                    }


                                }
                            }

                        }
                    }

                }
                // A surface container using the 'background' color from the theme
            }
        }
    }
}

