package com.dps0340.R6SDB

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.content.res.Resources
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_op.*
import kotlinx.android.synthetic.main.item.*
import org.jetbrains.anko.startActivity
import android.widget.TableLayout
import kotlinx.android.synthetic.main.item.view.*
import org.json.JSONArray
import org.json.JSONObject


class opActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_op)
        val actionBar = supportActionBar
        actionBar!!.title = "오퍼레이터"
        val arr = JSONArray(
            "[\"nokk\", \"warden\", \"mozzie\", \"gridlock\", \"nomad\", \"kaid\", \"clash\", \"maverick\", \"maestro\", \"alibi\", \"lion\", \"finka\", \"vigil\", \"dokkaebi\", \"zofia\", \"ela\", \"ying\", \"lesion\", \"mira\", \"jackal\", \"hibana\", \"echo\", \"caveira\", \"capitao\", \"blackbeard\", \"valkyrie\", \"buck\", \"frost\", \"mute\", \"sledge\", \"smoke\", \"thatcher\", \"ash\", \"castle\", \"pulse\", \"thermite\", \"montagne\", \"twitch\", \"doc\", \"rook\", \"jager\", \"bandit\", \"blitz\", \"iq\", \"fuze\", \"glaz\", \"tachanka\", \"kapkan\"]\n"
        )
        var child: View
        var parent: LinearLayout
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val len = arr.length() - 1
        val res = resources
        parent = LinearLayout(this)
        parent.weightSum = 4f
        var end = false
        for(i in 0..len) {
            if(i % 4 == 0 && i != 0) {
                parent = LinearLayout(this)
                parent.weightSum = 4f
                end = false
            }
            child = inflater.inflate(R.layout.item, null)
            child.layoutParams = TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
            val name = arr[i] as String +"_logo"
            val resID = res.getIdentifier(name, "drawable", packageName)
            child.image.setImageResource(resID)
            child.setOnClickListener {
                startActivity<describeActivity>(
                    "id" to arr[i].toString()
                )
            }
            parent.addView(child, i % 4)
            if(i % 4 == 0) {
                box.addView(parent, i / 4)
                box.invalidate()
                end = true
            }
            if(i == len && !end) {
                box.addView(parent, i / 4 + 1)
                box.invalidate()
            }
        }
    }
}
