package com.dps0340.R6SDB

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import org.json.JSONArray
import org.json.JSONObject


class DescribeActivity : AppCompatActivity() {


    private fun TextView.decorate() {
        this.setTextColor(ContextCompat.getColor(context, R.color.colorAccent))
        this.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        this.textSize = 20.0f
        this.gravity = Gravity.CENTER
    }

    private fun LinearLayout.decorate() {
        this.orientation = LinearLayout.VERTICAL
        this.gravity = Gravity.CENTER_VERTICAL
    }




    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_describe)


        val gunInfo = JSONObject(R.string.default_gun_info.toString())
        val operatorInfo = JSONObject(R.string.default_operator_info.toString())
        val res = resources
        val int = intent

        val id = int.getStringExtra("id")
        Log.i("intent", "intent id is $id")

        val isGun = gunInfo.has(id)
        val isOperator = operatorInfo.has(id)

        val root = findViewById<LinearLayout>(R.id.root)
        root.decorate()

        if (isGun) {
            val resID = res.getIdentifier(id, "drawable", packageName)
            val picture = ImageView(this)
            picture.setImageResource(resID)
            root.addView(picture)
        } else if (isOperator) {
            val name = id + "_picture"
            val name2 = id + "_logo"
            val nameID = res.getIdentifier(name, "drawable", packageName)
            val name2ID = res.getIdentifier(name2, "drawable", packageName)
            val picture = ImageView(this)
            val logo = ImageView(this)
            picture.setImageResource(nameID)
            logo.setImageResource(name2ID)
            root.addView(picture)
            root.addView(logo)
        }

        if (isGun) {
            dynamicJSONTextView(gunInfo, root, id)
        }

        if (isOperator) {
            dynamicJSONTextView(operatorInfo, root, id)
        }
        val actionBar = supportActionBar
        actionBar?.title = id
    }

    private fun dynamicJSONTextView(obj: JSONObject, rootV: LinearLayout, keyExpected: String?) {
        val key: String
        val value: String
        if (keyExpected == null) {
            val keys = obj.names()
            for (i in 0 until obj.length()) {
                dynamicJSONTextView(obj, rootV, keys.getString(i)) // 재귀적 forEach로 모든 원소를 call
            }
            return // 모든 loop가 끝난 후 함수 종료
        } else {
            key = keyExpected
            value = obj.getString(key) // key로 value 가지고오기
        }
        val usingLinearLayout = LinearLayout(this)
        usingLinearLayout.decorate()
        var isJsonObj: Boolean
        var isJsonArr: Boolean
        // 두번의 타입 체크
        try {
            JSONObject(value)
            isJsonObj = true
        } catch (e: org.json.JSONException) {
            isJsonObj = false
        }
        try {
            JSONArray(value)
            isJsonArr = true
        } catch (e: org.json.JSONException) {
            isJsonArr = false
        }
        if (isJsonObj) {
            val title = TextView(this)
            title.text = key
            title.decorate()
            dynamicJSONTextView(JSONObject(value), usingLinearLayout, null) // value에 있는 모든 원소를 call
            usingLinearLayout.invalidate()
        } else if (isJsonArr) {
            val linearLayout = LinearLayout(this)
            linearLayout.decorate()
            val arr = JSONArray(value)
            for (j in 0 until arr.length()) {
                val textV = TextView(this)
                textV.text = arr[j].toString()
                textV.decorate()
                linearLayout.addView(textV)
                linearLayout.invalidate()
            }
            usingLinearLayout.addView(linearLayout)
            usingLinearLayout.invalidate()
        } else {
            val keyText = TextView(this)
            val valueText = TextView(this)
            val linearLayout = LinearLayout(this)
            linearLayout.decorate()
            keyText.text = key
            keyText.decorate()
            valueText.text = value
            valueText.decorate()
            linearLayout.addView(keyText)
            linearLayout.addView(valueText)
            linearLayout.invalidate()
            usingLinearLayout.addView(linearLayout)
            usingLinearLayout.invalidate()
        }
        rootV.addView(usingLinearLayout)
        rootV.invalidate()
    }
}