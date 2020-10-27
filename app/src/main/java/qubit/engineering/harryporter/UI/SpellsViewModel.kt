package qubit.engineering.harryporter.UI

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import qubit.engineering.harryporter.Data.HousesItem
import qubit.engineering.harryporter.Data.SpellsItem
import qubit.engineering.harryporter.Network.CheckNetwork
import qubit.engineering.harryporter.Repo.HarryRepo

class SpellsViewModel(private val repo:HarryRepo): ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    val spells:LiveData<List<SpellsItem>> by lazy {
        repo.getAllSpells(compositeDisposable)
    }

    val network:LiveData<CheckNetwork> by lazy{
        repo.getState()
    }

}