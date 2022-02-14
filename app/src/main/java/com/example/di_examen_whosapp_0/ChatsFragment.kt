package com.example.di_examen_whosapp_0

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DividerItemDecoration




class ChatsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        /*
        Root es una variable que contiene el layout, para acceder
        a cualquier view deberemos llamarlo. Despues se debe devolver root.
         */
        val root = inflater.inflate(R.layout.fragment_chats, container, false)

        val listaCards = ArrayList<Card>()
        listaCards.add(Card(R.drawable.image1, R.string.card1))
        listaCards.add(Card(R.drawable.image2, R.string.card2))
        listaCards.add(Card(R.drawable.image3, R.string.card3))
        listaCards.add(Card(R.drawable.image4, R.string.card4))
        listaCards.add(Card(R.drawable.image5, R.string.card5))
        listaCards.add(Card(R.drawable.image6, R.string.card6))
        listaCards.add(Card(R.drawable.image7, R.string.card7))
        listaCards.add(Card(R.drawable.image8, R.string.card8))

        val recView = root.findViewById<RecyclerView>(R.id.recView)

        val adaptador = Adaptador(listaCards)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL, false)
        recView.addItemDecoration(
            DividerItemDecoration(
                recView.getContext(),
                DividerItemDecoration.VERTICAL
            )
        )


        adaptador.onClick = {
            val item = listaCards.get(recView.getChildAdapterPosition(it))
            val intent = Intent(context, Chat::class.java)

            val chatImagen = it.findViewById<ImageView>(R.id.idLogo)
            val chatTitulo = it.findViewById<TextView>(R.id.idTitulo)

            val pair1 = Pair.create<View, String>(chatImagen, chatImagen.transitionName) //tran_photo
            val pair = Pair.create<View, String>(chatTitulo, chatTitulo.transitionName) //tran_text

            //Animacion con elementos compartidos, no requerido
            //val options = ActivityOptionsCompat.makeSceneTransitionAnimation(requireActivity(), pair, pair1).toBundle()

            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(requireActivity()).toBundle()

            options?.putInt("chatTitulo", item.titulo)
            options?.putInt("chatFoto", item.foto)

            intent.putExtras(options!!)
            startActivity(intent, options)
        }

        return root
    }
}