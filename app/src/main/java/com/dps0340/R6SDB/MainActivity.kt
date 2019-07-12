package com.dps0340.R6SDB

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView



class MainActivity : AppCompatActivity() {


    private val mAdView: AdView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adRequest = AdRequest.Builder().build()
        mAdView!!.loadAd(adRequest)
    }
}
