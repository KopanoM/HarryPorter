package qubit.engineering.harryporter.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_spells.*
import qubit.engineering.harryporter.Data.HousesItem
import qubit.engineering.harryporter.Data.SpellsItem
import qubit.engineering.harryporter.R

class Spells : AppCompatActivity() {
    companion object{
        val SPELLS = "spells"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spells)
        val spell = intent.getSerializableExtra(SPELLS) as SpellsItem
        bindUI(spell)


    }

    fun bindUI(spell:SpellsItem){
        progress_bar_indi_spells.visibility = View.GONE
        spell_name.text =  spell.spell
        item_effect.text = spell.effect
        item_type.text = spell.type
    }
}