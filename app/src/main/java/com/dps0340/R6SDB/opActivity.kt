package com.dps0340.R6SDB

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_op.*
import kotlinx.android.synthetic.main.item.*
import org.jetbrains.anko.startActivity


class opActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_op)
        val actionBar = supportActionBar
        actionBar!!.title = "오퍼레이터"
        var child: View
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        for(i in 0..24) {
            child = inflater.inflate(R.layout.item, null)
            child.setOnClickListener {
                startActivity<describeActivity>()
            }
            box.addView(child, i)
            box.invalidate()
        }
    }
}
