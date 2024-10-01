package com.example.input

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.input.ui.theme.InputTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InputTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InputScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun InputScreen(modifier: Modifier = Modifier) {
    val textState = remember { mutableStateOf("") }
    val submittedTextState = remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            placeholder = { Text("Введите текст") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                submittedTextState.value = textState.value
                textState.value = ""
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Отправить")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = submittedTextState.value,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun InputScreenPreview() {
    InputTheme {
        InputScreen()
    }
}
