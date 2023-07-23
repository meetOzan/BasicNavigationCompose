package com.example.basicnavigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.basicnavigationcompose.ui.theme.BasicNavigationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicNavigationComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    Surface {
        BasicNavHost(navController = navController)
    }
}

// NavHost

// In that code I can change screens with Navigation without Args.
@Composable
fun BasicNavHost(navController: NavHostController) {
    androidx.navigation.compose.NavHost(
        navController = navController, startDestination = Main.route
    ) {
        composable(Main.route) {
            MainScreen({ navController.navigateSingleTopTo(Welcome.route) })
        }
        composable(Welcome.route) {
            WelcomeScreen(
                onGoBack = { navController.navigateSingleTopTo(Main.route) },
                name = "Selim 2"
            )
        }
    }
}

// infix navigate function for to use "launchSingleTop = true"
fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }