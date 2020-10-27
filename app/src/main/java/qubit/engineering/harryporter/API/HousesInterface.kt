package qubit.engineering.harryporter.API


import io.reactivex.Single
import kotlinx.coroutines.Deferred
import qubit.engineering.harryporter.Data.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HousesInterface {

    @GET("houses/{ID}")
    fun getRequestedHouse(
        @Path("ID") house: String,

    ): Single<Houses>

    @GET("characters/{character_ID}")
    fun getRequestedMember(
        @Path("character_ID") name: String,

        ): Single<Member>




    @GET("spells/")
    fun getAllSpells(): Single<List<SpellsItem>>

    @GET("houses/")
    fun getRequestedAllHouse(): Single<List<HousesItem>>

    @GET("characters/")
    fun getRequestedAllStudents(): Single<List<Member>>



}