package com.example.homeworkuri

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception


class SiteAdapter(private val listSiteData: List<UiItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when(viewType){
        SITE_TYPE -> {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_site, parent, false)
            SiteViewHolder(view)
        }
        TITLE_TYPE -> {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.text_item, parent, false)
            TitleViewHolder(view)
        }
        else -> throw Exception()
    }

    override fun getItemCount(): Int = listSiteData.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is SiteViewHolder -> holder.onBind(listSiteData[position] as UiItem.SiteData)
            is TitleViewHolder -> holder.onBind(listSiteData[position] as UiItem.TitleItem)
        }
    }

    override fun getItemViewType(position: Int): Int = when(listSiteData[position]) {
        is UiItem.SiteData -> SITE_TYPE
        is UiItem.TitleItem -> TITLE_TYPE
        else -> throw Exception()
    }


    companion object {
        private const val TITLE_TYPE = 1
        private const val SITE_TYPE = 2
    }
}