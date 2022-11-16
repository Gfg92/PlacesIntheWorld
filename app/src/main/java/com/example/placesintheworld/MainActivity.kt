package com.example.placesintheworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val juegos: FloatingActionButton = findViewById(R.id.fab1);
        juegos.setOnClickListener { lanzarParte2() }

        val items = ArrayList<Card>()
        items.add(Card(R.mipmap.image1, "Card 1"))
        items.add(Card(R.mipmap.image2, "Card 2"))
        items.add(Card(R.mipmap.image3, "Card 3"))
        items.add(Card(R.mipmap.image4, "Card 4"))
        items.add(Card(R.mipmap.image5, "Card 5"))
        items.add(Card(R.mipmap.image6, "Card 6"))
        items.add(Card(R.mipmap.image7, "Card 7"))
        items.add(Card(R.mipmap.image8, "Card 8"))
        items.add(Card(R.mipmap.image9, "Card 9"))


        val recView = findViewById<RecyclerView>(R.id.recView)

        recView.setHasFixedSize(true)

        val adaptador = Card_Adapter(items)
        recView.adapter = adaptador
        recView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        recView.itemAnimator = DefaultItemAnimator()

        adaptador.onClick = {
        }
    }
    // Inflar la toolbar creada, no la que te viene por defecto
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    fun lanzarParte2() {
        val i = Intent(this, Parte2Activity::class.java);
        startActivity(i);
    }

    // Opciones de la toolbar principal
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            (R.id.search_toolbar) -> {
                return true
            }
            (R.id.settings_toolbar) -> {
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

}