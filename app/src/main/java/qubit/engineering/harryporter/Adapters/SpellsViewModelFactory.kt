package qubit.engineering.harryporter.Adapters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import qubit.engineering.harryporter.Repo.HarryRepo
import qubit.engineering.harryporter.UI.MemberViewModel
import qubit.engineering.harryporter.UI.SpellsViewModel

class SpellsViewModelFactory (
    private val repo: HarryRepo,
): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SpellsViewModel(repo) as T
    }
}