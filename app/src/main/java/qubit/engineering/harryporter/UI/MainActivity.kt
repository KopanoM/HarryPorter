package qubit.engineering.harryporter.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import qubit.engineering.harryporter.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnClickListeners()

    }

    fun setOnClickListeners(){


        houses_cardview.setOnClickListener {
            val intent = Intent(this, Houses::class.java)

            startActivity(intent)
        }

        spells_cardView.setOnClickListener {
            val intent = Intent(this, ShowAllSpells::class.java)

            startActivity(intent)
        }

        students_cardview.setOnClickListener {
            val intent = Intent(this, AllMembers::class.java)
            //intent.putExtra("genre", "Drama")
            startActivity(intent)
        }

        settings_cardview.setOnClickListener {

            Toast.makeText(applicationContext,"Coming soon",Toast.LENGTH_SHORT).show()
            //val intent = Intent(this, AllMovies::class.java)
            //intent.putExtra("genre", "Sci-Fi")
            //startActivity(intent)
        }



    }

}