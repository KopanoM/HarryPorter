package qubit.engineering.harryporter.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_show_members.*
import qubit.engineering.harryporter.Data.HousesItem
import qubit.engineering.harryporter.R
import qubit.engineering.harryporter.UI.ShowMember.Companion.INDI_MEMBER

class ShowMembers : AppCompatActivity() {

    companion object{
        val MEMBER_NAME = "member_name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_members)
        val house = intent.getSerializableExtra(MEMBER_NAME) as HousesItem
        initListview(house)

    }

fun initListview(housesItem: HousesItem){


    // use arrayadapter and define an array
    val arrayAdapter: ArrayAdapter<*>


    // access the listView from xml file
    var mListView = findViewById<ListView>(R.id.listview_members)
    arrayAdapter = ArrayAdapter(this,
        android.R.layout.simple_list_item_1, housesItem.members)
    mListView.adapter = arrayAdapter

    mListView.setOnItemClickListener { parent, view, position, id ->

        //val element = users[position]
        //val t = ""




        val intent = Intent(this, ShowMember::class.java)
        intent.putExtra(INDI_MEMBER, housesItem.members[position])
        startActivity(intent)



    }



}



}