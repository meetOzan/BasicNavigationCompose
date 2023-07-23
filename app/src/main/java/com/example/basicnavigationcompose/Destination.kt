package com.example.basicnavigationcompose

interface Destination{
    val route : String
}

object Main : Destination {
    override val route: String = "main_route"
}

object Welcome : Destination {
    override val route = "welcome_screen"
}