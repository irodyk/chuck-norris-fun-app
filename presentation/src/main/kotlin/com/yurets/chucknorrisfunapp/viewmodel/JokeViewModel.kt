package com.yurets.chucknorrisfunapp.viewmodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class JokeViewModel(val id: Int, val text: String, val userVote: Int, val overallRating: Int)
    : Parcelable, Comparable<JokeViewModel>{

    override fun compareTo(other: JokeViewModel): Int {
        return id.compareTo(other.id)
    }
}