
package com.example.di_examen_whosapp_0

import android.graphics.BitmapFactory
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.recyclerview.widget.RecyclerView


class Adaptador(var items: ArrayList<Card>) : RecyclerView.Adapter<Adaptador.TarjViewHolder>()  {
    lateinit var onClick: (View) -> Unit
    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imag : ImageView
        var texto : TextView

        init {
            imag = itemView.findViewById(R.id.idLogo)
            texto = itemView.findViewById(R.id.idTitulo)
        }

        fun bindTarjeta(t: Card, onClick: (View) -> Unit) = with(itemView) {
            imag.setImageResource(t.foto)
            texto.text = resources.getString(t.titulo)
            setOnClickListener{ onClick(itemView) }

            //Imagen redonda
            val fotoUsuario = findViewById<ImageView>(R.id.idLogo)

            val bitmap = BitmapFactory.decodeResource(resources, t.foto)
            val drawable = RoundedBitmapDrawableFactory.create(resources, bitmap)
            drawable.isCircular = true
            fotoUsuario.setImageDrawable(drawable)
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.item,
            viewGroup,
            false
        )



        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        var itemCard = items[pos]
        viewHolder.bindTarjeta(itemCard, onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
