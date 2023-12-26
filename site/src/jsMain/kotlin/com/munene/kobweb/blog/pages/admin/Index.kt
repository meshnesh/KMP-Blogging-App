package com.munene.kobweb.blog.pages.admin

import androidx.compose.runtime.Composable
import com.munene.kobweb.blog.util.isUserLoggedIn
import com.varabyte.kobweb.core.Page


@Page
@Composable
fun HomePage() {
    isUserLoggedIn {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() {

}