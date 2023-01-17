package com.example.homeworkuri

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SiteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun onBind(item: UiItem.SiteData) {
        val image = itemView.findViewById<ImageView>(R.id.logo)
        val name = itemView.findViewById<TextView>(R.id.tvSiteName)

        getLogo(item.imageUrl, image)
        name.text = item.name

        itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(item.siteUri)
            name.context.startActivity(intent)
        }
    }


    private fun getLogo(url: String, image: ImageView) {
        Glide.with(image)
            .load(url)
            .into(image)
    }
}