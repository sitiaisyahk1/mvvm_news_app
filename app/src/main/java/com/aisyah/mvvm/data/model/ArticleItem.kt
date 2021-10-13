package com.aisyah.mvvm.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArticleItem(
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
    val source: SourceItem,
    val title: String? = null,
    val url: String? = null,
    val urlToImage: String? = null
): Parcelable