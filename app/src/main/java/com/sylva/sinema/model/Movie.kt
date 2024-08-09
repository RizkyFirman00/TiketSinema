package com.sylva.sinema.model

import android.os.Parcel
import android.os.Parcelable

data class Movie(
    val movieName: String? = "",
    val description: String? = "",
    val rating: String? = "",
    val moviePoster: String? = "",
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(movieName)
        parcel.writeString(description)
        parcel.writeValue(rating)
        parcel.writeString(moviePoster)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}