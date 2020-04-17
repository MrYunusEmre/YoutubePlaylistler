package com.example.youtubeplaylistler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {

    val API_KEY = "AIzaSyDsuOzTkT4dKfwuZph6StE7KfzkWbH25dg"
    val channelId = "UClpEUtFu_dXbrUJ6kc3QtlA"

    var gelenVeri:PlayListData? = null
    var oynatmaListeleri:List<PlayListData.Items> ? = null

    var myAdapter:playlistAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var apiInterface = ApiClient.client?.create(apiInterface::class.java)
        var apiCall = apiInterface?.tumListeleriGetir(channelId,API_KEY,25)

        apiCall?.enqueue(object : Callback<PlayListData>{
            override fun onFailure(call: Call<PlayListData>, t: Throwable) {
                Log.e("ehe",""+t.printStackTrace())
            }

            override fun onResponse(call: Call<PlayListData>, response: Response<PlayListData>) {

                gelenVeri = response.body() // tum veri
                oynatmaListeleri = gelenVeri?.items // listeler

                myAdapter = playlistAdapter(oynatmaListeleri)
                var layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
                recyclerView.layoutManager = layoutManager

                recyclerView.adapter = myAdapter

                supportActionBar?.setSubtitle("Toplam Liste : ${oynatmaListeleri?.size}")

            }

        })




    }
}
