package com.dps0340.R6SDB

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class gunActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gun)
        val actionBar = supportActionBar
        actionBar!!.title = "총"
    }
}
