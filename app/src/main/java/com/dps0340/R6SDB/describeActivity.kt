package com.dps0340.R6SDB

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.widget.VideoView
import android.R.attr.start




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
        val actionBar = supportActionBar
        actionBar!!.title = "슬레지"
        vV = findViewById<VideoView>(R.id.vv)
        vV.setVideoPath("android.resource://" + packageName + "/" + R.raw.sledgeanimation)
        vV.start()
        vV.setOnCompletionListener(MediaPlayer.OnCompletionListener { vV.start() })
    }
}