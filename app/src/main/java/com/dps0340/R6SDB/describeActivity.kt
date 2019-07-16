package com.dps0340.R6SDB

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.widget.VideoView


class describeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_describe)
        val actionBar = supportActionBar
        actionBar!!.title = "슬레지"
        val vV = findViewById<VideoView>(R.id.vv)
        vV.setVideoPath("android.resource://" + packageName + "/" + R.raw.sledgeanimation)
        vV.start()
        vV.setOnCompletionListener(MediaPlayer.OnCompletionListener { vV.start() })
    }
}