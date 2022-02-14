package com.example.di_examen_whosapp_0

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm,lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> ChatsFragment()
            1 -> EstadosFragment()
            2 -> LlamadasFragment()
            else -> ChatsFragment()
        }
    }
} 