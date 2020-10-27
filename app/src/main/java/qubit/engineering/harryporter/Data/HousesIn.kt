package qubit.engineering.harryporter.Data


import com.google.gson.annotations.SerializedName

data class HousesIn(
    val colors: List<String>,
    val founder: String,
    val headOfHouse: String,
    val houseGhost: String,
    @SerializedName("_id")
    val id: String,
    val mascot: String,
    val members: List<MemberX>,
    val name: String,
    val school: String,
    @SerializedName("__v")
    val v: Int,
    val values: List<String>
)