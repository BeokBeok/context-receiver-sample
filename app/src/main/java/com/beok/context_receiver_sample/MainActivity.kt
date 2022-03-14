package com.beok.context_receiver_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sort()
    }

    private fun sort() {
        with(Comparator.naturalOrder<Int>()) {
            listOf(3, 5, 1).sort()
        }
        Comparator.naturalOrder<Int>().run {
            listOf(3, 5, 1).sort()
        }
        listOf(3, 5, 1).sortedWith(Comparator.naturalOrder())
    }
}
