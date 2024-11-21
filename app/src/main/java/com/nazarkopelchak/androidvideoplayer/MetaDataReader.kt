package com.nazarkopelchak.androidvideoplayer

import android.app.Application
import android.net.Uri
import android.provider.MediaStore
import com.nazarkopelchak.androidvideoplayer.data.MetaData

interface MetaDataReader {
    fun getMetaDataFromUri(uri: Uri): MetaData?
}

class MetaDataReaderImpl(
    private val app: Application
): MetaDataReader {

    override fun getMetaDataFromUri(uri: Uri): MetaData? {
        if (uri.scheme != "content") {
            return null
        }

        val filename = app.contentResolver
            .query(
                uri,
                arrayOf(MediaStore.Video.VideoColumns.DISPLAY_NAME),
                null,
                null
            )?.use { cursor ->
                val index = cursor.getColumnIndex(MediaStore.Video.VideoColumns.DISPLAY_NAME)
                cursor.moveToFirst()
                cursor.getString(index)
            }

        return filename?.let { fullFileName ->
            MetaData(
                fileName = Uri.parse(fullFileName).lastPathSegment ?: return null
            )
        }
    }
}