package qubit.engineering.harryporter.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_houses.*
import kotlinx.android.synthetic.main.activity_show_all_spells.*
import qubit.engineering.harryporter.API.APIClient
import qubit.engineering.harryporter.API.HousesInterface
import qubit.engineering.harryporter.Adapters.HousesAdapter
import qubit.engineering.harryporter.Adapters.HousesViewModelFactory
import qubit.engineering.harryporter.Adapters.MemberViewModelFactory
import qubit.engineering.harryporter.Adapters.SpellsViewModelFactory
import qubit.engineering.harryporter.Data.HousesItem
import qubit.engineering.harryporter.Data.SpellsItem
import qubit.engineering.harryporter.R
import qubit.engineering.harryporter.Repo.HarryRepo
import qubit.engineering.harryporter.UI.Spells.Companion.SPELLS

class ShowAllSpells : AppCompatActivity() {
    private lateinit var viewModel: SpellsViewModel
    private lateinit var factory: SpellsViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all_spells)
        val api: HousesInterface = APIClient.getClient()
        val repo = HarryRepo(api)
        factory = SpellsViewModelFactory(repo)
        viewModel = ViewModelProviders.of(this,factory).get(SpellsViewModel::class.java)
        //viewModel.allHouses
        viewModel.spells.observe(
            this,{
                progress_bar_spells.visibility = View.GONE
                initListview(it)

            }
        )




    }
    fun initListview(spells: List<SpellsItem>){


        // use arrayadapter and define an array

        val nameOfSpells = arrayListOf<String>()
        for(spell in spells){
            nameOfSpells.add(spell.spell)
        }

        val arrayAdapter: ArrayAdapter<*>


        // access the listView from xml file
        var mListView = findViewById<ListView>(R.id.listview_spells)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, nameOfSpells)
        mListView.adapter = arrayAdapter

        mListView.setOnItemClickListener { parent, view, position, id ->

            //val element = users[position]
            //val t = ""




            val intent = Intent(this, Spells::class.java)
            intent.putExtra(SPELLS, spells[position])
            startActivity(intent)



        }



    }
}