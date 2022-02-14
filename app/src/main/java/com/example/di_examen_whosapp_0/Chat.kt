package com.example.di_examen_whosapp_0

import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Chat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val chatTitulo = findViewById<TextView>(R.id.tvTitulo)
        val chatLogo = findViewById<ImageView>(R.id.ivLogo)


        val bundle = intent.extras
        val chatText = bundle!!.getInt("chatTitulo")
        val chatImage = bundle!!.getInt("chatFoto")

        chatTitulo.setText(chatText)
        chatLogo.setImageResource(chatImage)

        val fab = findViewById(R.id.fabMini) as FloatingActionButton
        fab.setImageResource(R.drawable.ic_play)

        fab.setOnClickListener {
            val transformar = getDrawable(R.drawable.add_animaciones) as AnimatedVectorDrawable
            fab.setImageDrawable(transformar)
            transformar.start()
        }

    }
}