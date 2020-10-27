package qubit.engineering.harryporter.Data


import com.google.gson.annotations.SerializedName

data class MemberX(
    @SerializedName("_id")
    val id: String,
    val name: String
)