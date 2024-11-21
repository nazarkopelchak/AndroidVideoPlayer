package com.nazarkopelchak.androidvideoplayer

import android.app.Application
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object Module {

    @Provides
    @ViewModelScoped
    fun provideVideoPlayer(app: Application): Player {
        return ExoPlayer.Builder(app.applicationContext).build()
    }

    @Provides
    @ViewModelScoped
    fun provideMEtaDataReader(app: Application): MetaDataReader {
        return MetaDataReaderImpl(app)
    }
}