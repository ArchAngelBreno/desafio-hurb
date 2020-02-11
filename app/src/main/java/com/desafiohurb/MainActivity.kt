package com.desafiohurb

import android.os.Bundle
import android.view.MenuItem
import com.desafiohurb.core.base.BaseActivity
import com.desafiohurb.core.extension.startFragment
import com.desafiohurb.feature.home.presentation.ui.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_app.*
import kotlin.system.exitProcess

class MainActivity: BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
    }

    private fun initUi() {
        bottomNavigation.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
        appToolbar.title = "Desafio Hurb"
        supportFragmentManager.startFragment<HomeFragment>(R.id.menuFragmentContainer)

    }

    override fun onBackPressed() {
        finishApp()
    }

    private fun finishApp() {
        Snackbar.make(principalContainer, "Sair?", Snackbar.LENGTH_LONG)
            .setAction("Deseja realmente sair do app?" ) {
                exitProcess(0)
            }.show()
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> supportFragmentManager.startFragment<HomeFragment>(R.id.menuFragmentContainer)
            }
            return@setOnNavigationItemSelectedListener true
        }

        return true
    }
}