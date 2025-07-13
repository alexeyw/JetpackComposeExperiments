package com.example.androidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidapp.presentation.MasonryGridScreen
import com.example.androidapp.ui.theme.AndroidAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidAppTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding),
        ) {
            composable("home") {
                ScreenList(navController)
            }
            composable("masonry_grid") {
                MasonryGridScreen()
            }
        }
    }
}

@Composable
fun ScreenList(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        stickyHeader {
            Text(text = "Examples")
        }
        item {
            TextButton(onClick = { navController.navigate("masonry_grid") }) {
                Text(text = "Masonry Grid")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    AndroidAppTheme {
        HomeScreen()
    }
}
