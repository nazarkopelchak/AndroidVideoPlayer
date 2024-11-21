package com.nazarkopelchak.androidvideoplayer.data

import android.net.Uri
import androidx.media3.common.MediaItem

data class VideoItem(
    val uri: Uri,
    val mediaItem: MediaItem,
    val name: String
)
