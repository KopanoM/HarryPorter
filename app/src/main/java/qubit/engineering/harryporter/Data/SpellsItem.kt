package qubit.engineering.harryporter.Data


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SpellsItem(
    val effect: String,
    @SerializedName("_id")
    val id: String,
    val spell: String,
    val type: String,
    @SerializedName("__v")
    val v: Int
):Serializable