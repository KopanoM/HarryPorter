package qubit.engineering.harryporter.Data


import com.google.gson.annotations.SerializedName

data class Member(
    val bloodStatus: String,
    val deathEater: Boolean,
    val dumbledoresArmy: Boolean,
    @SerializedName("_id")
    val id: String,
    val ministryOfMagic: Boolean,
    val name: String,
    val orderOfThePhoenix: Boolean,
    val role: String,
    val school: String,
    val species: String,
    @SerializedName("__v")
    val v: Int
)