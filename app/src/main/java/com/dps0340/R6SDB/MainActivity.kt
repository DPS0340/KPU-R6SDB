package com.dps0340.R6SDB

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {

    private lateinit var mAdView: AdView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().addTestDevice("CE3E359CA22C3DA6EA75412F4DC91633").build()
        mAdView.loadAd(adRequest)
        val op = findViewById<CardView>(R.id.op)
        val gun = findViewById<CardView>(R.id.op)
        val map = findViewById<CardView>(R.id.op)

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
