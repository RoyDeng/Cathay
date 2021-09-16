package tw.roy.deng.cathay.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    val title: String,
    val date: String,
    val week: String
) : Parcelable