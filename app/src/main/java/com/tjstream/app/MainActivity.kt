package com.tjstream.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.util.Util
import com.tjstream.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var player: ExoPlayer? = null

    // Stream URL from FIFA World Cup API
    private val STREAM_URL = "https://fifaworldcup.cfd/api/stream?q=english"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize player and start streaming
        initializePlayer()
    }

    private fun initializePlayer() {
        player = ExoPlayer.Builder(this).build().also { exoPlayer ->
            binding.playerView.player = exoPlayer

            // Create media item from stream URL
            val mediaItem = MediaItem.fromUri(STREAM_URL)
            exoPlayer.setMediaItem(mediaItem)

            // Prepare and auto-play
            exoPlayer.prepare()
            exoPlayer.playWhenReady = true
        }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            // Resume playback
            if (player != null) {
                player?.playWhenReady = true
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (Util.SDK_INT <= 23 || player == null) {
            initializePlayer()
        }
    }

    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT <= 23) {
            releasePlayer()
        }
    }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT > 23) {
            releasePlayer()
        }
    }

    private fun releasePlayer() {
        player?.let {
            it.release()
        }
        player = null
    }
}
