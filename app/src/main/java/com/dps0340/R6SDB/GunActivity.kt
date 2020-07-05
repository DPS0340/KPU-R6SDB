package com.dps0340.R6SDB

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_gun.*
import kotlinx.android.synthetic.main.gun_item.view.*
import org.jetbrains.anko.startActivity
import org.json.JSONArray
import java.util.*

class GunActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gun)
        val actionBar = supportActionBar
        actionBar!!.title = "총"
        val arr = JSONArray(R.string.default_gun_array_info)
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val len = arr.length() - 1
        val res = resources
        for (i in 0..len) {
            val gun = inflater.inflate(R.layout.gun_item, null)
            val name = arr[i] as String
            val resID = res.getIdentifier(name, "drawable", packageName)
            gun.img.setImageResource(resID)
            gun.text.setText(name.replace("_", " ").replace("gun ", "").toUpperCase(Locale.getDefault()))
            gun.setOnClickListener {
                startActivity<DescribeActivity>(
                    "id" to arr[i].toString()
                )
            }
            gunroot.addView(gun)
            gunroot.invalidate()
        }
    }
}
