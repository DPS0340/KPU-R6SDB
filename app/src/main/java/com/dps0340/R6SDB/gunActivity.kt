package com.dps0340.R6SDB

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_gun.*
import org.jetbrains.anko.startActivity

class gunActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gun)
        val actionBar = supportActionBar
        actionBar!!.title = "총"
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        for(i in 1..25) {
            val gun = inflater.inflate(R.layout.gun_item, gunroot)
            gun.setOnClickListener {
                startActivity<describeActivity>(
                    "id" to "vector"
                )
            }
            gunroot.invalidate()
        }
    }
}
