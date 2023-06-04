package com.punkil.taazakhabar

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        val list :  List<Article>

        val title = intent.getStringExtra("title")
        val content = intent.getStringExtra("content")
        val image = intent.getStringExtra("image")
        val url = intent.getStringExtra("url")
        val articleTitle : TextView = findViewById(R.id.titleArticle)
        val articleDesc : TextView = findViewById(R.id.descArticte)
        val articleImage : ImageView = findViewById(R.id.imageArticle)
        Glide.with(this).load(image).into(articleImage)
        articleDesc.text = content
        articleTitle.text = title

        val seeFullArticle : Button = findViewById(R.id.seeFull)
        seeFullArticle.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("$url"))
            startActivity(intent)
        }


    }
}