package com.example.basicnavigationcompose

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Destination{
    val route : String
}

object Main : Destination {
    override val route: String = "main_route"
}

object Welcome : Destination {
    override val route = "welcome_screen"
    const val argsKey = "name"
    val routeWithArgs = "${route}/{${argsKey}}"
    val args = listOf(
        navArgument(argsKey) {NavType.StringType}
    )

}