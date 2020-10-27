package qubit.engineering.harryporter.Repo

import androidx.lifecycle.LiveData
import io.reactivex.disposables.CompositeDisposable
import qubit.engineering.harryporter.API.HousesInterface
import qubit.engineering.harryporter.Data.HousesItem
import qubit.engineering.harryporter.Data.Member
import qubit.engineering.harryporter.Data.SpellsItem
import qubit.engineering.harryporter.Network.CheckNetwork

class HarryRepo(private val api: HousesInterface) {

    lateinit var housesDataSource: HarryDataSource
    lateinit var _myHouses: MutableList<List<HousesItem>>
    val houseList: MutableList<List<HousesItem>>
        get() = _myHouses


    lateinit var _myMember: MutableList<Member>
    val member: MutableList<Member>
        get() = _myMember

    lateinit var _mySpells: MutableList<List<SpellsItem>>
    val spells: MutableList<List<SpellsItem>>
        get() = _mySpells

    lateinit var _myAllMembers: MutableList<List<Member>>
    val members: MutableList<List<Member>>
        get() = _myAllMembers

    fun getAllHouses(
        compositeDisposable: CompositeDisposable

    ): LiveData<List<HousesItem>> {
        _myHouses = arrayListOf()
        housesDataSource = HarryDataSource(api, compositeDisposable)
        housesDataSource.getHouses()
        return housesDataSource.downloadedHousesResponse
    }

    fun getIndividualMember(
        memberUID: String,
        compositeDisposable: CompositeDisposable

    ): LiveData<Member> {
        _myMember = arrayListOf()
        housesDataSource = HarryDataSource(api, compositeDisposable)
        housesDataSource.getIndividualMember(memberUID)
        return housesDataSource.downloadedMemberResponse
    }

    fun getAllSpells(
        compositeDisposable: CompositeDisposable
    ): LiveData<List<SpellsItem>> {
        _mySpells = arrayListOf()
        housesDataSource = HarryDataSource(api, compositeDisposable)
        housesDataSource.getSpells()
        return housesDataSource.downloadedSpellsResponse


    }

    fun getAllMembers(
        compositeDisposable: CompositeDisposable
    ): LiveData<List<Member>> {
        _mySpells = arrayListOf()
        housesDataSource = HarryDataSource(api, compositeDisposable)
        housesDataSource.getAllMembers()
        return housesDataSource.downloadedAllMembersResponse


    }


    fun getState(): LiveData<CheckNetwork> {
        return housesDataSource.networkState
    }


}