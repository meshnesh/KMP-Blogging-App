package com.munene.kobweb.blog.pages.admin

import androidx.compose.runtime.Composable
import com.munene.kobweb.blog.components.SidePanel
import com.munene.kobweb.blog.util.Constants.PAGE_WIDTH
import com.munene.kobweb.blog.util.isUserLoggedIn
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text


@Page
@Composable
fun HomePage() {
    isUserLoggedIn {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(modifier = Modifier
            .fillMaxSize()
            .maxWidth(PAGE_WIDTH.px)) {
            SidePanel()
        }
    }
}