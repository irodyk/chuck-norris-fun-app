package com.yurets.chucknorrisfunapp.viewmodel

import android.os.Parcel
import android.os.Parcelable

data class JokeViewModel(val id: Int, val text: String, val userVote: Int, val overallRating: Int)
    : Parcelable, Comparable<JokeViewModel>{

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt())

    override fun compareTo(other: JokeViewModel): Int {
        return id.compareTo(other.id)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(text)
        parcel.writeInt(userVote)
        parcel.writeInt(overallRating)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<JokeViewModel> {
        override fun createFromParcel(parcel: Parcel): JokeViewModel {
            return JokeViewModel(parcel)
        }

        override fun newArray(size: Int): Array<JokeViewModel?> {
            return arrayOfNulls(size)
        }
    }
}