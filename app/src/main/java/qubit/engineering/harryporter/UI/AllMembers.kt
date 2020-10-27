package qubit.engineering.harryporter.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_all_members.*
import kotlinx.android.synthetic.main.activity_houses.*
import kotlinx.android.synthetic.main.activity_houses.progress_bar_content
import qubit.engineering.harryporter.API.APIClient
import qubit.engineering.harryporter.API.HousesInterface
import qubit.engineering.harryporter.Adapters.AllMemberViewModelFactory
import qubit.engineering.harryporter.Adapters.HousesViewModelFactory
import qubit.engineering.harryporter.Adapters.MemberViewModelFactory
import qubit.engineering.harryporter.Data.HousesItem
import qubit.engineering.harryporter.Data.Member
import qubit.engineering.harryporter.R
import qubit.engineering.harryporter.Repo.HarryRepo
import qubit.engineering.harryporter.UI.ShowMeOneMember.Companion.ONE_INDI_MEMBER

class AllMembers : AppCompatActivity() {
    private lateinit var viewModel: AllMemberViewModel
    private lateinit var factory: AllMemberViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_members)
        progress_bar_all_members.visibility = View.VISIBLE
        val api: HousesInterface = APIClient.getClient()
        val repo = HarryRepo(api)
        factory = AllMemberViewModelFactory(repo)
        viewModel = ViewModelProviders.of(this,factory).get(AllMemberViewModel::class.java)
        viewModel.allMembers.observe(
        this,{
                progress_bar_all_members.visibility = View.GONE
                initListview(it)

            }

        )

    }

    fun initListview(members: List<Member>){

        val nameOfMembers = arrayListOf<String>()
        for(member in members){
            nameOfMembers.add(member.name)
        }

        // use arrayadapter and define an array
        val arrayAdapter: ArrayAdapter<*>


        // access the listView from xml file
        var mListView = findViewById<ListView>(R.id.listview_all_members)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, nameOfMembers)
        mListView.adapter = arrayAdapter

        mListView.setOnItemClickListener { parent, view, position, id ->

            val element = members[position]





            val intent = Intent(this, ShowMeOneMember::class.java)
            intent.putExtra(ONE_INDI_MEMBER, element)
            startActivity(intent)



        }



    }


}