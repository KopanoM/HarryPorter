package qubit.engineering.harryporter.UI

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import qubit.engineering.harryporter.Data.Member
import qubit.engineering.harryporter.Repo.HarryRepo

class MemberViewModel(private val harryRepo: HarryRepo, memberID:String): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val memberDets: LiveData<Member> by lazy{

        harryRepo.getIndividualMember(memberID,compositeDisposable)

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}