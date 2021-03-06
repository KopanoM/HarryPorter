package qubit.engineering.harryporter.API

import io.reactivex.Single
import qubit.engineering.harryporter.Data.Houses
import retrofit2.http.GET
import retrofit2.http.Query



interface SpellsInterface {
    @GET(".")
    fun getRequestedSpell(
        @Query("t") name: String,
        @Query("y") year: String
    ): Single<Houses>

}