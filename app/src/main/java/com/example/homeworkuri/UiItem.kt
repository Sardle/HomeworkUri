package com.example.homeworkuri

sealed class UiItem {
    data class SiteData(
        val imageUrl: String,
        val name: String,
        val siteUri: String
    ) : UiItem()

    data class TitleItem(val title: String) : UiItem()
}
