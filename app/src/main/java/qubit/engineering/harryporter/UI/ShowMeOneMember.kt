package qubit.engineering.harryporter.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_show_me_one_member.*
import kotlinx.android.synthetic.main.activity_show_member.*
import kotlinx.android.synthetic.main.activity_show_member.item_member_ministry2
import kotlinx.android.synthetic.main.activity_show_member.item_member_name
import kotlinx.android.synthetic.main.activity_show_member.item_member_school2
import kotlinx.android.synthetic.main.activity_show_member.item_member_species2
import kotlinx.android.synthetic.main.activity_show_member.progress_bar_member
import qubit.engineering.harryporter.Adapters.MemberViewModelFactory
import qubit.engineering.harryporter.Data.HousesItem
import qubit.engineering.harryporter.Data.Member
import qubit.engineering.harryporter.R

class ShowMeOneMember : AppCompatActivity() {
    companion object{
        val ONE_INDI_MEMBER = "one_individual_member"
    }

    private lateinit var viewModel: MemberViewModel
    private lateinit var factory: MemberViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_me_one_member)
        val member = intent.getSerializableExtra(ONE_INDI_MEMBER) as Member
        bindUI(member)
    }
    fun bindUI(member: Member){
        progress_bar_member3.visibility = View.GONE
        item_member_name3.text = member.name
        item_member_blood3.text = member.bloodStatus
        item_member_ministry3.text = member.ministryOfMagic.toString()
        item_member_school3.text = member.school
        item_member_species3.text = member.species
        item_role3.text = member.role
    }
}