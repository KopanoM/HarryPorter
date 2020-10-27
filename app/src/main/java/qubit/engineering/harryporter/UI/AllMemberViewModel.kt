package qubit.engineering.harryporter.UI

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import qubit.engineering.harryporter.Data.Member
import qubit.engineering.harryporter.Repo.HarryRepo

class AllMemberViewModel(private val repo:HarryRepo) : ViewModel(){
    private val compositeDisposable = CompositeDisposable()

    val memberDets: LiveData<List<Member>> by lazy{
        repo.getAllMembers(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}