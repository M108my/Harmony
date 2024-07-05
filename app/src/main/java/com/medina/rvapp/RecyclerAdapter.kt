package com.medina.rvapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerAdapter:RecyclerView.Adapter<RecyclerAdapter.ViewHolder> (){
    var songs: MutableList<Song>  = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter(songs : MutableList<Song>, context: Context){
        this.songs = songs
        this.context = context
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = songs.get(position)
        holder.bind(item, context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_song_list, parent, false))
    }
    override fun getItemCount(): Int {
        return songs.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val titlesong = view.findViewById(R.id.tvTitlesong) as TextView
        val autor = view.findViewById(R.id.tvAutor) as TextView
        val avatar = view.findViewById(R.id.ivAvatar) as ImageView
        fun bind(song:Song, context: Context){
            titlesong.text = song.titlesong
            autor.text = song.autor

            avatar.loadUrl(song.photo)
            itemView.setOnClickListener(View.OnClickListener {

                val intent = Intent(context, Descripcion::class.java)

                // Pass any necessary data to the new activity
                intent.putExtra("songTitle", song.titlesong)
                intent.putExtra("songAuthor", song.autor)
                intent.putExtra("songPhoto", song.photo)
                intent.putExtra("descripcion", song.descripcion)
                intent.putExtra("audioResId", song.audioResId)

                // Start the new activity
                context.startActivity(intent)
            })
        }
        fun ImageView.loadUrl(url: String) {
            Picasso.get().load(url).into(this)
        }
    }
}