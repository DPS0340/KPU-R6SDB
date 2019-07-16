package com.dps0340.R6SDB

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class opActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_op)
        val actionBar = supportActionBar
        actionBar!!.title = "오퍼레이터"
    }
}
