package com.reckonco.coroutinesdemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reckonco.coroutinesdemo.ui.theme.CoroutinesDemoTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoroutinesDemoTheme {
                // A surface container using the 'background' color from the theme
                MainScreen()
            }
        }
    }
}



@Composable
fun MainScreen() {

    val viewModel = MainActivityViewModel()
    //val count = viewModel.count.observeAsState(0)
    val count: MutableState<Int> = remember {mutableStateOf(0)}

    val num = viewModel.num1.observeAsState()

    androidx.compose.material.Surface(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            //User Message
            Text(text = "This thread has ${num.value} value")
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {viewModel.coroutine2()}) {
                Text(text = "Download User Data")
            }

            Spacer(modifier = Modifier.height(40.dp))
            Text(text = count.value.toString())
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { count.value++ }) {
                Text(text = "Click Here")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}