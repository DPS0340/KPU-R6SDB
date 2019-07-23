package com.dps0340.R6SDB

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import org.json.JSONArray
import org.json.JSONObject


class describeActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_describe)


        val guninfo = JSONObject(
            R.string.guninfo.toString()
        )
        val opinfo = JSONObject(
            R.string.opinfo.toString()
        )

        val res = resources
        val int = intent

        val id = int.getStringExtra("id")
        Log.i("intent", "intent id is" + id)

        val isgun = guninfo.has(id)
        val isop = opinfo.has(id)

        val root = findViewById<LinearLayout>(R.id.root)


        if(isgun) {
            val name = id
            val resID = res.getIdentifier(name, "drawable", packageName)
            val picture = ImageView(this)
            picture.setImageResource(resID)
            root.addView(picture)
        } else if(isop) {
            val name = id + "_picture"
            val name2 = id + "_logo"
            var resID = res.getIdentifier(name, "drawable", packageName)
            val picture = ImageView(this)
            picture.setImageResource(resID)
            resID = res.getIdentifier(name2, "drawable", packageName)
            val logo = ImageView(this)
            logo.setImageResource(resID)
            root.addView(picture)
            root.addView(logo)
        }

        if(isgun) {
            dynamicJSONTextView(guninfo, root)
        }

        if(isop) {
            dynamicJSONTextView(opinfo, root)
        }
        val actionBar = supportActionBar
        actionBar!!.title = id
    }

    fun dynamicJSONTextView(obj: JSONObject, root: LinearLayout) {
        val keys = obj.names()
        val usingLL = LinearLayout(this)
        for (i in 0..obj.length() - 1) {
            val key = keys.getString(i)
            val value = obj.getString(key)
            var isjsonobj: Boolean
            var isjsonarr: Boolean
            try {
                JSONObject(value)
                isjsonobj = true
            } catch (e: Error) {
                isjsonobj = false
            }
            try {
                JSONArray(value)
                isjsonarr = true
            } catch (e: Error) {
                isjsonarr = false
            }
            if (isjsonobj) {
                val LL = LinearLayout(this)
                dynamicJSONTextView(JSONObject(value), LL)
                usingLL.addView(LL)
                usingLL.invalidate()
            } else if(isjsonarr) {
                val LL = LinearLayout(this)
                val arr = JSONArray(value)
                for(i in 0..arr.length() - 1) {
                    val textV = TextView(this)
                    textV.setText(arr[i].toString())
                    LL.addView(LL)
                    LL.invalidate()
                }
                usingLL.addView(LL)
                usingLL.invalidate()
            } else {
                val textV = TextView(this)
                textV.setText(key + value)
                usingLL.addView(textV)
                usingLL.invalidate()
            }
        }
        root.addView(usingLL)
        root.invalidate()
    }
}