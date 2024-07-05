package com.medina.rvapp

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val titlesong = view.findViewById(R.id.tvTitlesong) as TextView
    val autor = view.findViewById(R.id.tvAutor) as TextView
    val avatar = view.findViewById(R.id.ivAvatar) as ImageView

    fun bind(song:Song, context: Context){
        titlesong.text = song.titlesong
        autor.text = song.autor
        itemView.setOnClickListener(View.OnClickListener { Toast.makeText(context, song.titlesong, Toast.LENGTH_SHORT).show() })
        avatar.loadUrl(song.photo)
    }
    fun ImageView.loadUrl(url: String) {
        Picasso.get().load(url).into(this)
    }
}