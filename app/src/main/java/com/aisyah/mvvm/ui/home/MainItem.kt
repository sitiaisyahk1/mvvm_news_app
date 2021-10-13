package com.aisyah.mvvm.ui.home

import android.view.View
import com.aisyah.mvvm.R
import com.aisyah.mvvm.data.model.ArticleItem
import com.aisyah.mvvm.databinding.NewsItemViewBinding
import com.aisyah.mvvm.utils.loadImage
import com.xwray.groupie.viewbinding.BindableItem

class MainItem (
    private val article: ArticleItem,
    private val onClick: (ArticleItem) -> Unit

): BindableItem<NewsItemViewBinding>(){

    override fun bind(viewBinding: NewsItemViewBinding, position: Int) {
        //get data dari news
        viewBinding.apply {
            itemName.text = article.title
            itemImage.loadImage(article.urlToImage)
            itemDesc.text = article.description

            itemCard.setOnClickListener {
                onClick(article)
            }
        }

    }

    override fun getLayout(): Int = R.layout.news_item_view

    override fun initializeViewBinding(view: View): NewsItemViewBinding {
        return NewsItemViewBinding.bind(view)
    }
}