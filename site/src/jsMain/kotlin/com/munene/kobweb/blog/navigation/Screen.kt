package com.munene.kobweb.blog.navigation

sealed class Screen(val route: String) {
    data object AdminHome : Screen(route = "/admin")
    data object AdminLogin : Screen(route = "/admin/login")
    data object AdminCreate : Screen(route = "/admin/create") {
        fun passPostId(id: String) = "/admin/create"
    }

    data object AdminMyPosts : Screen(route = "/admin/myposts") {
        fun searchByTitle(query: String) = "/admin/myposts"
    }
//
//    object AdminSuccess : Screen(route = "/admin/success") {
//        fun postUpdated() = "/admin/success?${UPDATED_PARAM}=true"
//    }
//
//    object HomePage : Screen(route = "/")
//    object SearchPage : Screen(route = "/search/query") {
//        fun searchByCategory(category: Category) =
//            "/search/query?${CATEGORY_PARAM}=${category.name}"
//
//        fun searchByTitle(query: String) = "/search/query?${QUERY_PARAM}=$query"
//    }
//
//    object PostPage : Screen(route = "/posts/post") {
//        fun getPost(id: String) = "/posts/post?${POST_ID_PARAM}=$id"
//    }
}