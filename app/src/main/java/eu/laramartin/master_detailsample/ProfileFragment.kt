package eu.laramartin.master_detailsample


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import eu.laramartin.master_detailsample.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        if (context!!.resources.getBoolean(R.bool.isTablet)) {
            displayMasterDetailLayout()
        } else {
            displaySingleLayout()
        }

        return binding.root
    }

    private fun displaySingleLayout() {
        binding.profileLayout.accountTextView.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_profile_fragment_to_fragment_account)
        )
        binding.profileLayout.notificationsTextView.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_profile_fragment_to_fragment_notifications)
        )
        binding.profileLayout.settingsTextView.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_profile_fragment_to_fragment_settings)
        )
    }

    private fun displayMasterDetailLayout() {
        val detailNavHost =
            childFragmentManager.findFragmentById(R.id.profile_nav_container) as NavHostFragment

        binding.profileLayout.accountTextView.setOnClickListener {
            detailNavHost.navController.navigate(R.id.fragment_account)
        }

        binding.profileLayout.notificationsTextView.setOnClickListener {
            detailNavHost.navController.navigate(R.id.fragment_notifications)
        }

        binding.profileLayout.settingsTextView.setOnClickListener {
            detailNavHost.navController.navigate(R.id.fragment_settings)
        }
    }
}
