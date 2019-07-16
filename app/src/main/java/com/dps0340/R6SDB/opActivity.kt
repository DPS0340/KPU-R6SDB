package com.dps0340.R6SDB

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_op.*
import kotlinx.android.synthetic.main.item.*
import org.jetbrains.anko.startActivity
import android.widget.TableLayout




class opActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_op)
        val actionBar = supportActionBar
        actionBar!!.title = "오퍼레이터"
        var child: View
        var parent: LinearLayout
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        for(i in 0..9) {
            parent = LinearLayout(this)
            parent.weightSum = 4f
            for(j in 0..3) {
                child = inflater.inflate(R.layout.item, null)
                child.layoutParams = TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
                child.setOnClickListener {
                    startActivity<describeActivity>()
                }
                parent.addView(child, j)
            }
            box.addView(parent, i)
            box.invalidate()
        }
    }
}
