package com.medina.rvapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
    }

    fun setUpRecyclerView(){
        lateinit var mRecyclerView : RecyclerView
        val mAdapter : RecyclerAdapter = RecyclerAdapter()

        mRecyclerView = findViewById(R.id.rvSongList) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)

        mAdapter.RecyclerAdapter(getSongs(), this)
        mRecyclerView.adapter = mAdapter
    }

    fun getSongs():MutableList<Song>{
        var songs:MutableList<Song> = ArrayList()
        songs.add(Song("Please Please Please", "Sabrina Carpenter", "https://i.pinimg.com/736x/a4/b0/30/a4b030ab7de388e9bd5477bf7e094d03.jpg","Una súplica emotiva y apasionada, esta canción captura la desesperación de un corazón roto.", R.raw.please))
        songs.add(Song("WILDFLOWER", "Billie Eilish", "https://i.pinimg.com/736x/e6/92/a1/e692a1dfb0175c48c3b5d2ab1509fa12.jpg","Un himno de libertad y autoexpresión, 'WILDFLOWER' celebra la belleza en la imperfección.", R.raw.wildflower))
        songs.add(Song("kyoto", "Omar Courts, De La Rose",  "https://i.pinimg.com/564x/9b/06/9f/9b069f734ca00328cd218988f50df168.jpg","Una travesía sonora por la ciudad de Kyoto, llena de paisajes sonoros ricos y melódicos.", R.raw.kyoto))
        songs.add(Song("Still Got Time", "dexter in the newsagent", "https://i.pinimg.com/564x/d4/ec/55/d4ec557834644da1e18bc1ee4ae51153.jpg","Un recordatorio de que siempre hay tiempo para cambiar y crecer, con ritmos relajados y letras profundas.", R.raw.stillgottime))
        songs.add(Song("The boy is mine", "Ariana Grande", "https://i.pinimg.com/736x/93/9f/7a/939f7ae39794cb7abc7549a1235a2b07.jpg","Una confrontación poderosa entre dos voces increíbles, luchando por el amor de su vida.", R.raw.theboyismine))
        songs.add(Song("Espresso", "Sabrina Carpenter" , "https://i.pinimg.com/736x/97/ff/2d/97ff2d429b0e6c297b2ca000295e55fe.jpg","Una explosión de energía y ritmo, 'Espresso' es tan vigorizante como una taza de café fuerte.", R.raw.espresso))
        songs.add(Song("Good Days", "SZA", "https://i.pinimg.com/564x/0a/e2/09/0ae20923c372768058244213dfdc90a9.jpg","Una reflexión sobre el pasado y el futuro, buscando optimismo y buenos momentos por venir.", R.raw.gooddays))
        songs.add(Song("Stolen Dance", "Milky Chance", "https://i.pinimg.com/564x/42/87/e4/4287e402e4cff32bc15a8e3ebf751c8f.jpg","Una melodía pegajosa y bailable, perfecta para aquellos momentos robados de felicidad.", R.raw.stolendance))
        songs.add(Song("Low", "SZA", "https://i.pinimg.com/564x/81/12/9d/81129df0a44f413874c82f7649ce8cd2.jpg","Una exploración introspectiva de las emociones bajas y cómo encontrar fuerza en medio de la adversidad.", R.raw.low))
        songs.add(Song("CHIHIRO", "Billie Eilish", "https://i.pinimg.com/736x/ec/00/38/ec003824688972fcff0196c7219c2937.jpg","Un tributo etéreo y melancólico inspirado en el mundo mágico de 'Spirited Away'.", R.raw.chihiro))
        songs.add(Song("Valentine", "Laufey", "https://i.pinimg.com/736x/3d/9d/dc/3d9ddc2083f8f8aa957a30e5ddec9947.jpg","Una balada dulce y romántica que captura la esencia del amor en el Día de San Valentín.", R.raw.valentine))
        songs.add(Song("Cherry", "Lana Del Rey", "https://i.pinimg.com/564x/27/41/e0/2741e04ecd5079b490d3448d3d509a85.jpg","Una canción sensual y melancólica que evoca los tonos oscuros y seductores de la nostalgia.", R.raw.cherry))
        return songs

    }
}