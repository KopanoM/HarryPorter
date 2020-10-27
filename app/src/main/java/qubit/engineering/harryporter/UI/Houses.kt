package qubit.engineering.harryporter.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_houses.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import qubit.engineering.harryporter.API.APIClient
import qubit.engineering.harryporter.API.HousesInterface
import qubit.engineering.harryporter.Adapters.HousesAdapter
import qubit.engineering.harryporter.Adapters.HousesViewModelFactory
import qubit.engineering.harryporter.Adapters.RecyclerViewClickListener
import qubit.engineering.harryporter.Data.Houses
import qubit.engineering.harryporter.Data.HousesItem
import qubit.engineering.harryporter.R
import qubit.engineering.harryporter.Repo.HarryRepo

class Houses : AppCompatActivity(), RecyclerViewClickListener{
    //private lateinit var listView ListView
    private lateinit var housesAdapter: HousesAdapter
    private var houses: MutableList<HousesItem> = arrayListOf()
    private lateinit var viewModel: HousesViewModel
    private lateinit var factory: HousesViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_houses)
        progress_bar_content.visibility = View.VISIBLE
        val api: HousesInterface = APIClient.getClient()
        val repo = HarryRepo(api)
        factory = HousesViewModelFactory(repo)
        viewModel = ViewModelProviders.of(this,factory).get(HousesViewModel::class.java)
        //viewModel.allHouses
        viewModel.allHouses.observe(

            this, Observer {houses ->
                recycler_view.also {
                    it.layoutManager = LinearLayoutManager(applicationContext)
                    it.setHasFixedSize(true)
                    progress_bar_content.visibility = View.GONE
                    it.adapter = HousesAdapter(houses,this)
                }
            }
        )
        supportActionBar?.apply {
            // Set toolbar title/app title
            //title = name


            // Display the app icon in action bar/toolbar
            //setDisplayShowHomeEnabled(true)
            setDisplayUseLogoEnabled(true)
        }
        //hideProgress(false)
        viewModel = ViewModelProviders.of(this).get(HousesViewModel::class.java)
        //initHouses()
        //initRecyclerView()


/*
        GlobalScope.launch(Dispatchers.Main) { // launch a new coroutine in background and continue
            val api: HousesInterface = APIClient.getClient()
            //val test = api.getRequestedHouse("Gryffindor")
            api.getRequestedHouse("5a05e2b252f721a3cf2ea33f").subscribeOn(Schedulers.io()).subscribe(
                {
                    print(it)

                },
                {
                    print(it)

                }
            )
            //print(test)


        }
        */

        //initListview();
    }




    private fun initRecyclerView() {
        recycler_view.layoutManager = LinearLayoutManager(this)
        housesAdapter = HousesAdapter(houses,this)
        recycler_view.adapter = housesAdapter
/*
        recycler_view.apply {

            layoutManager = LinearLayoutManager(context)
            adapter = MovieAdapter(mov)
        }

 */

    }
    private fun hideProgress(state: Boolean) {
        if (state) {
            progress_bar_content.visibility = View.VISIBLE
        } else {
            progress_bar_content.visibility = View.GONE
        }

    }
    /*
    fun initListview(){


        // use arrayadapter and define an array
        val arrayAdapter: ArrayAdapter<*>
        val users = arrayOf(
            "Gryffindor", "Ravenclaw", "Slytherin",
            "Hufflepuff",
        )

        // access the listView from xml file
        var mListView = findViewById<ListView>(R.id.houses_list_view)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, users)
        mListView.adapter = arrayAdapter

        mListView.setOnItemClickListener { parent, view, position, id ->

            val element = users[position]
            val t = ""




            //val intent = Intent(this, AllMovies::class.java)
            //intent.putExtra("genre", "Action")
            //startActivity(intent)



        }



    }

     */

    override fun onRecyclerViewItemClick(view: View, house: HousesItem) {
        super.onRecyclerViewItemClick(view, house)
        when(view.id){
            R.id.item_lin ->{
                val intent = Intent(this, IndividualHouses::class.java)
                intent.putExtra(IndividualHouses.HOUSE_NAME, house)
                startActivity(intent)
                Toast.makeText(this,house.mascot,Toast.LENGTH_SHORT).show()
            }


        }

    }
}