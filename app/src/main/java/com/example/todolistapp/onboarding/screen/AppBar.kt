package com.example.todolistapp.onboarding.screen
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todolistapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class AppBar : Fragment() {
    private lateinit var navview: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.appbar, container, false)

        navview = view.findViewById(R.id.nav_view)

        navview.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_notes -> replaceFragment(ListTask())
                R.id.nav_done -> replaceFragment(CompleteTask())
            }
            true
        }
        return view
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.appbar, fragment)
        fragmentTransaction.commit()
    }
}