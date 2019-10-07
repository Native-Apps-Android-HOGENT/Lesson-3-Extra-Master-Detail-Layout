package eu.laramartin.master_detailsample

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment

        bottom_navigation_view.setupWithNavController(navController = navHostFragment.navController)

        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            supportActionBar!!.title = destination.label
            when (destination.id) {
                R.id.fragment_account,
                R.id.fragment_settings,
                R.id.fragment_notifications -> {
                    supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                }
                else -> supportActionBar!!.setDisplayHomeAsUpEnabled(false)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                navHostFragment.navController.popBackStack()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
