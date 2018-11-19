package com.narbase.bottomnavigation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        const val homeItem = 0
        const val searchItem = 1
        const val accountItem = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val homeItem = AHBottomNavigationItem(getString(R.string.home), R.drawable.home)
        val searchItem = AHBottomNavigationItem(getString(R.string.search), R.drawable.search)
        val accountItem = AHBottomNavigationItem(getString(R.string.account), R.drawable.account)

        bottomNavigation.addItem(homeItem)
        bottomNavigation.addItem(searchItem)
        bottomNavigation.addItem(accountItem)

        setupTabSelectionAction()
    }

    private fun setupTabSelectionAction() {
        bottomNavigation.setOnTabSelectedListener { position, _ ->
            when (position) {
                homeItem -> mainText.text = getString(R.string.home)
                searchItem -> mainText.text = getString(R.string.search)
                accountItem -> mainText.text = getString(R.string.account)
            }

            true
        }
    }
}
