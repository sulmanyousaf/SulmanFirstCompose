package com.applico.sulmanfirstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.applico.sulmanfirstcompose.ui.theme.SulmanFirstComposeTheme
import com.applico.sulmanfirstcompose.ui.theme.appTextColors
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SettingContent()
        }
    }
}

@Composable
fun SettingContent(){
    SulmanFirstComposeTheme {
        FirstApp(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun FirstApp(modifier: Modifier = Modifier,
             names: List<String> = listOf("World", "Compose")
){
    val scrollState = rememberScrollState()
    Scaffold(modifier = modifier) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxHeight().padding(innerPadding).verticalScroll(scrollState)) {
            Column(
                modifier= Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                for (name in names) {
                    Greeting(
                        name = name,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }

            Column(
                modifier= Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                for (name in names) {
                    Greeting(
                        name = name,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    val extraPadding = if (expanded) 48.dp else 0.dp

    Surface(color = MaterialTheme.appTextColors.warningIcon) {
        Row(modifier= Modifier.padding(24.dp)) {
            Column(modifier = modifier.weight(1f).padding(bottom = extraPadding)) {
                Text(text = "Hello ", color = MaterialTheme.appTextColors.body)
                Text(text = name, color = MaterialTheme.appTextColors.subheading)
            }
            ElevatedButton(
                modifier = modifier.weight(1f),
                onClick = { expanded = !expanded }
            ) {
                Text(text = if (expanded) "Show Less" else "Show More")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SettingContent()
}