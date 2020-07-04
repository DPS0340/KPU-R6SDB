package com.dps0340.R6SDB

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
//import com.google.android.gms.ads.AdRequest
//import com.google.android.gms.ads.AdView
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val op = findViewById<CardView>(R.id.op)
        val gun = findViewById<CardView>(R.id.gun)
        val map = findViewById<CardView>(R.id.map)

        op.setOnClickListener {
            startActivity<opActivity>()
        }
        gun.setOnClickListener {
            startActivity<gunActivity>()
        }
        map.setOnClickListener {
            startActivity<mapActivity>()
        }
    }
}
