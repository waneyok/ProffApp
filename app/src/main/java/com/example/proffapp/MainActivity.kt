package com.example.proffapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.uikit.storybook.StoryBookScreen
import com.example.uikit.theme.ProffAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProffAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StoryBookScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
