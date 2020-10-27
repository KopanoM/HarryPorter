package qubit.engineering.harryporter.UI




import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import qubit.engineering.harryporter.Data.HousesItem
import qubit.engineering.harryporter.Network.CheckNetwork
import qubit.engineering.harryporter.Repo.HarryRepo

class HousesViewModel(private val housesRepo: HarryRepo) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    //private List<HouseItem> houses

    //private val movies = MutableLiveData<List<Movie>>

    val allHouses: LiveData<List<HousesItem>> by lazy {

        housesRepo.getAllHouses(compositeDisposable)
    }

    val networkState: LiveData<CheckNetwork> by lazy {
        housesRepo.getState()
    }

    init {

    }




    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}