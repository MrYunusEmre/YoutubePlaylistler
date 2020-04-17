package com.example.youtubeplaylistler

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface apiInterface {
//https://www.googleapis.com/youtube/v3/playlists?part=snippet&channelId=UClpEUtFu_dXbrUJ6kc3QtlA&key=AIzaSyDsuOzTkT4dKfwuZph6StE7KfzkWbH25dg
    @GET("playlists?part=snippet")
    fun tumListeleriGetir(@Query("channelId") channelID:String,@Query("key") apiKey:String,
                          @Query("maxResults")limit:Int):Call<PlayListData>
}