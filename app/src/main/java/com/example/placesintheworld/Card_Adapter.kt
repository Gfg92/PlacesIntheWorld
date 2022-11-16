package com.example.placesintheworld

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView

class Card_Adapter(var items: ArrayList<Card>) :
    RecyclerView.Adapter<Card_Adapter.TarjViewHolder>() {
    lateinit var onClick: (View) -> Unit

    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var imagen: ImageView
        private var titulo: TextView
        var toolbar: Toolbar



        init {
            imagen = itemView.findViewById(R.id.imagen_imageView)
            titulo = itemView.findViewById(R.id.titulo_carta)
            toolbar = itemView.findViewById(R.id.toolbar_Card)
        }

        fun bindTarjeta(t: Card, onClick: (View) -> Unit) = with(itemView) {
            imagen.setImageResource(t.imagen)
            titulo.setText(t.titulo)

            toolbar.inflateMenu(R.menu.menu_item)
            toolbar.title = t.titulo
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.card_item, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item, onClick)
        val selected = viewHolder.toolbar

        selected.setOnMenuItemClickListener(object : Toolbar.OnMenuItemClickListener {
            override fun onMenuItemClick(item1: MenuItem?): Boolean {
                when (item1!!.itemId) {
                    (R.id.boton_cancelar) -> {
                        items.removeAt(viewHolder.adapterPosition)
                        notifyItemRemoved(viewHolder.adapterPosition)
                        return true
                    }
                    else -> {
                        return true
                    }
                }
            }
        })


    }

    override fun getItemCount(): Int {
        return items.size
    }

}