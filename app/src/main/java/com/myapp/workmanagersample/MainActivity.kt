package com.myapp.workmanagersample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myapp.workmanagersample.ui.theme.WorkManagerSampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WorkManagerSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        Greeting("Android")
                        Button(
                            onClick = { viewModel.startWorker() },
                            modifier = Modifier.padding(top = 10.dp)
                        ) {
                            Text(text = "処理開始(同期×前の処理があったら開始しない)")
                        }
                        Button(
                            onClick = { viewModel.startWorkerAndReplace() },
                            modifier = Modifier.padding(top = 10.dp)
                        ) {
                            Text(text = "処理開始(同期×前の処理があったら前の処理を中止して開始)")
                        }
                        Button(
                            onClick = { viewModel.startAsyncWorkerAndAppend() },
                            modifier = Modifier.padding(top = 10.dp)
                        ) {
                            Text(text = "処理開始(非同期×前の処理の後ろまで待機)")
                        }
                        Button(
                            onClick = { viewModel.startAsyncWorker() },
                            modifier = Modifier.padding(top = 10.dp)
                        ) {
                            Text(text = "処理開始(非同期×続けて実施)")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WorkManagerSampleTheme {
        Greeting("Android")
    }
}