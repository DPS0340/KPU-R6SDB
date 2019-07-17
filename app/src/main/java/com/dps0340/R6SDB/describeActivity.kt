package com.dps0340.R6SDB

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.widget.VideoView
import android.R.attr.start
import android.content.Intent
import android.util.Log
import kotlinx.android.synthetic.main.activity_describe.*
import kotlinx.android.synthetic.main.item.view.*


class describeActivity : AppCompatActivity() {

    lateinit var vV: VideoView
    var seekTime: Int = 0

    public override fun onPause() {
        super.onPause()
        if (vV != null && vV.isPlaying()) {
            vV.pause()
            seekTime = vV.getCurrentPosition()
        }
    }
    public override fun onResume() {
        super.onResume()
        vV.start()
        vV.seekTo(seekTime)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_describe)
        val res = resources
        val int = intent
        val id = int.getStringExtra("id")
        Log.i("intent", "intent id is" + id)
        val name = id + "_picture"
        val resID = res.getIdentifier(name, "drawable", packageName)
        picture.setImageResource(resID)
        val actionBar = supportActionBar
        actionBar!!.title = id
        vV = findViewById<VideoView>(R.id.vv)
        vV.setVideoPath("android.resource://" + packageName + "/" + R.raw.sledgeanimation)
        vV.start()
        vV.setOnCompletionListener(MediaPlayer.OnCompletionListener { vV.start() })
    }
}