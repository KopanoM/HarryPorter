package qubit.engineering.harryporter.UI

import android.os.Bundle
import qubit.engineering.harryporter.R
import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment

class IntroductionScreens : AppIntro() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isLaunch()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        } else {
            putLaunch()
        }

        supportActionBar?.apply {
            hide()
        }
        // Make sure you don't call setContentView!

        // Call addSlide passing your Fragments.
        // You can use AppIntroFragment to use a pre-built fragment
        addSlide(
            AppIntroFragment.newInstance(
                imageDrawable = R.drawable.magicwand,
                title = "Welcome to Wizardly",
                description = "View all information regarding Hogwarts, School of Witchcraft and Wizardry"
            )
        )
        addSlide(
            AppIntroFragment.newInstance(
                imageDrawable = R.drawable.fire,
                title = "Magic Spells",
                description = "Track your spells, houses and pupils much easier"
            )
        )
        addSlide(
            AppIntroFragment.newInstance(
                imageDrawable = R.drawable.potion,
                title = "Spells and Portions",
                description = "Easily track your spells and potions and see what your friends are up to"
            )
        )
    }

    fun isLaunch(): Boolean {
        val preference =
            getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
        val isLaunch = preference.getBoolean("islaunch", false)
        return isLaunch

    }

    fun putLaunch() {
        var islaunch: Boolean
        val preference =
            getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putBoolean("islaunch", true)
        editor.commit()
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        // Decide what to do when the user clicks on "Skip"
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        // Decide what to do when the user clicks on "Done"
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}