package qubit.engineering.harryporter.Adapters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import qubit.engineering.harryporter.Repo.HarryRepo
import qubit.engineering.harryporter.UI.HousesViewModel
import qubit.engineering.harryporter.UI.MemberViewModel

class MemberViewModelFactory(
    private val repo: HarryRepo,
    private val memberID: String,
): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MemberViewModel(repo,memberID) as T
    }
}