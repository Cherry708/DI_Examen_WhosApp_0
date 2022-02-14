package com.example.di_examen_whosapp_0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "WhosApp"

        
        val viewPager: ViewPager2 = findViewById(R.id.pager)
        viewPager.adapter = SectionsPagerAdapter(this,supportFragmentManager,lifecycle)
        //viewPager.setPageTransformer(ZoomPageTransformer())

        val tabs: TabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "CHATS"
                1 -> "ESTADOS"
                2 -> "LLAMADAS"
                else -> "CHATS"
            }
        }.attach()
    }
}