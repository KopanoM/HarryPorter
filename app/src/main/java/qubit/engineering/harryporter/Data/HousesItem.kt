package qubit.engineering.harryporter.Data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class HousesItem(
    val colors: List<String>,
    val founder: String,
    val headOfHouse: String,
    val houseGhost: String,
    @SerializedName("_id")
    val id: String,
    val mascot: String,
    val members: List<String>,
    val name: String,
    val school: String,
    @SerializedName("__v")
    val v: Int,
    val values: List<String>
): Serializable