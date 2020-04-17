package com.example.youtubeplaylistler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.squareup.picasso.PicassoProvider
import kotlinx.android.synthetic.main.tek_satir_view.view.*

class playlistAdapter(tumListeler:List<PlayListData.Items>?): RecyclerView.Adapter<playlistAdapter.playListViewHolder>(){

    var oynatmaListeleri = tumListeler



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): playListViewHolder {

        var inflater = LayoutInflater.from(parent.context)
        var tekSatırPlaylist = inflater.inflate(R.layout.tek_satir_view,parent,false)

        return playListViewHolder(tekSatırPlaylist)
    }

    override fun getItemCount(): Int {
        return oynatmaListeleri!!.size
    }

    override fun onBindViewHolder(holder: playListViewHolder, position: Int) {

        var currentSatır = oynatmaListeleri?.get(position)
        holder.setData(currentSatır,position)


    }

    inner class playListViewHolder(tekSatır:View) : RecyclerView.ViewHolder(tekSatır) {

        var tekSatırPlaylist = tekSatır as CardView

        var title = tekSatırPlaylist.tvListeAd
        var resim = tekSatırPlaylist.circleView

        fun setData(currentSatır:PlayListData.Items?,position:Int){

            title.text = currentSatır?.snippet?.title
            Glide.with(tekSatırPlaylist?.context)
                .load(currentSatır?.snippet?.thumbnails?.high?.url.toString())
                .into(resim)


        }

    }

}