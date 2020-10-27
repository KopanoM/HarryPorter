package qubit.engineering.harryporter.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_show_member.*
import qubit.engineering.harryporter.API.APIClient
import qubit.engineering.harryporter.API.HousesInterface
import qubit.engineering.harryporter.Adapters.HousesViewModelFactory
import qubit.engineering.harryporter.Adapters.MemberViewModelFactory
import qubit.engineering.harryporter.Data.HousesItem
import qubit.engineering.harryporter.R
import qubit.engineering.harryporter.Repo.HarryRepo

class ShowMember : AppCompatActivity() {
    companion object{
        val INDI_MEMBER = "individual_member"
    }

    private lateinit var viewModel: MemberViewModel
    private lateinit var factory: MemberViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_member)
        val api: HousesInterface = APIClient.getClient()
        val repo = HarryRepo(api)
        val memberID = intent.getStringExtra(INDI_MEMBER)!!
        factory = MemberViewModelFactory(repo,memberID)
        viewModel = ViewModelProviders.of(this,factory).get(MemberViewModel::class.java)
        viewModel.memberDets.observe(

            this,{member ->
                progress_bar_member.visibility = View.GONE
                item_member_name.text = member.name
                item_member_blood2.text = member.bloodStatus
                item_member_ministry2.text = member.ministryOfMagic.toString()
                item_member_school2.text = member.school
                item_member_species2.text = member.species
                item_role2.text = member.role

            }
        )



    }

    fun bindUI(){




    }
}