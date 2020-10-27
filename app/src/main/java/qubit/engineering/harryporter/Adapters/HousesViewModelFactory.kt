package qubit.engineering.harryporter.Adapters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import qubit.engineering.harryporter.Repo.HarryDataSource
import qubit.engineering.harryporter.Repo.HarryRepo
import qubit.engineering.harryporter.UI.HousesViewModel

class HousesViewModelFactory(
    private val repo: HarryRepo,


): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HousesViewModel(repo) as T
    }
}