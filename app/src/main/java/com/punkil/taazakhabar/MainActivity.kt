package com.punkil.taazakhabar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.content.PackageManagerCompat.LOG_TAG
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {


    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
      getNews()


    }
    private fun getNews(){
        val news = NewsService.newsInstance.fetchHeadlines("in",Constants.API_KEY)
        news.enqueue(object : Callback<News>{
            override fun onFailure(call: Call<News>,t:Throwable){
                println(t.message)
            }
            override fun onResponse(call: Call<News>,response: Response<News>){
                val newsResponse = response.body()
                newsResponse?.let{
                recyclerView.adapter = NewsAdapter(this@MainActivity,newsResponse.articles)
                }
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }
        })
    }
}