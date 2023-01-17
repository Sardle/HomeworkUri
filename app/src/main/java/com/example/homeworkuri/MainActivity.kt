package com.example.homeworkuri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listSite = Server.getSites()
        val recycler = findViewById<RecyclerView>(R.id.rvSiteList)

        val adapter = SiteAdapter(listSite)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}