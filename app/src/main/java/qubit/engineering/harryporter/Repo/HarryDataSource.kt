package qubit.engineering.harryporter.Repo

import android.graphics.Movie
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import qubit.engineering.harryporter.API.HousesInterface
import qubit.engineering.harryporter.Data.Houses
import qubit.engineering.harryporter.Data.HousesItem
import qubit.engineering.harryporter.Data.Member
import qubit.engineering.harryporter.Data.SpellsItem
import qubit.engineering.harryporter.Network.CheckNetwork
import java.lang.Exception

class HarryDataSource(
    private val api: HousesInterface,
    private val compositeDisposable: CompositeDisposable
) {



    private var harry: MutableList<List<HousesItem>> = arrayListOf()
    private val _harry = MutableLiveData<List<HousesItem>>()
   //val housesFrom: LiveData<List<Movie>>
    //get() = _harry
    private val _networkState = MutableLiveData<CheckNetwork>()
    val networkState: LiveData<CheckNetwork>
    get() = _networkState

    private val _downloadedHousesResponse = MutableLiveData<List<HousesItem>>()
    val downloadedHousesResponse: LiveData<List<HousesItem>>
    get() = _downloadedHousesResponse

    private val _downloadedMemberResponse = MutableLiveData<Member>()
    val downloadedMemberResponse: LiveData<Member>
    get() = _downloadedMemberResponse

    private val _downloadedSpellsResponse = MutableLiveData<List<SpellsItem>>()
    val downloadedSpellsResponse: LiveData<List<SpellsItem>>
    get() = _downloadedSpellsResponse

    private val _downloadedAllMembersResponse = MutableLiveData<List<Member>>()
    val downloadedAllMembersResponse: LiveData<List<Member>>
    get() = _downloadedAllMembersResponse

    fun getHouses(){
        _networkState.postValue(CheckNetwork.LOADING)
        try{

            compositeDisposable.add(
                api.getRequestedAllHouse()
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                            _downloadedHousesResponse.postValue(it)
                            _networkState.postValue(CheckNetwork.LOADED)

                        },
                        {

                            _networkState.postValue(CheckNetwork.ERROR)

                        }
                    )
            )
        }catch (e: Exception){
            Log.i("error",e.toString())

        }
    }

    fun getIndividualMember(memberID:String){
        _networkState.postValue(CheckNetwork.LOADING)
        try{

            compositeDisposable.add(
                api.getRequestedMember(memberID)
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                            _downloadedMemberResponse.postValue(it)
                            _networkState.postValue(CheckNetwork.LOADED)

                        },
                        {
                            _networkState.postValue(CheckNetwork.ERROR)
                        }
                    )

            )

        }catch (e:Exception){

        }
    }

    fun getSpells(){
        _networkState.postValue(CheckNetwork.LOADING)
        try{

            compositeDisposable.add(
                api.getAllSpells()
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        _downloadedSpellsResponse.postValue(it)
                        _networkState.postValue(CheckNetwork.LOADED)
                    },
                        {
                            _networkState.postValue(CheckNetwork.ERROR)

                        }

                    )
            )

        }catch (e:Exception){

        }



    }

    fun getAllMembers(){

        _networkState.postValue(CheckNetwork.LOADING)
        try{

            compositeDisposable.add(
                api.getRequestedAllStudents()
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        _downloadedAllMembersResponse.postValue(it)
                        _networkState.postValue(CheckNetwork.LOADED)
                    },
                        {
                            _networkState.postValue(CheckNetwork.ERROR)

                        }

                    )
            )

        }catch (e:Exception){

        }


    }








}