package qubit.engineering.harryporter.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_individual_houses.*
import kotlinx.android.synthetic.main.item_houses.*
import qubit.engineering.harryporter.Data.HousesItem
import qubit.engineering.harryporter.R

class IndividualHouses : AppCompatActivity() {

    companion object{
        val HOUSE_NAME = "house_passed"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_individual_houses)
        val house = intent.getSerializableExtra(HOUSE_NAME) as HousesItem
        bindUi(house)
    }

    fun bindUi(housesItem: HousesItem){
        item_house_name1.text = housesItem.name
        item_founder1.text = housesItem.founder
        item_mascot1.text = housesItem.mascot
        item_school1.text = housesItem.school
        item_head_house1.text = housesItem.headOfHouse
        item_ghost1.text = housesItem.houseGhost
        var image = 0
        if (housesItem.name == "Gryffindor") {
            image = R.drawable.gryffindor
        } else if (housesItem.name == "Ravenclaw") {
            image = R.drawable.ravenclaw
        } else if (housesItem.name == "Slytherin") {
            image = R.drawable.slytherin
        } else if (housesItem.name == "Hufflepuff") {
            image = R.drawable.hufflepuff
        }
        house_thumbnail1.setImageResource(image)
        btnViewMembers.setOnClickListener{
            Toast.makeText(applicationContext,"All Members",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ShowMembers::class.java)
            intent.putExtra(ShowMembers.MEMBER_NAME, housesItem)
            startActivity(intent)
        }
    }
}