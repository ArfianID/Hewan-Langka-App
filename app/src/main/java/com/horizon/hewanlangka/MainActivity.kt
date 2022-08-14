package com.horizon.hewanlangka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    private lateinit var rvHewan: RecyclerView
    private var list: ArrayList<Hewan> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Hewan Langka di Indonesia"
        setContentView(R.layout.activity_main)

        rvHewan = findViewById(R.id.rv_Hewan)
        rvHewan.setHasFixedSize(true)

        list.addAll(DataHewan.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvHewan.layoutManager = LinearLayoutManager(this)
        val listHewanAdapter = ListHewanAdapter(list)
        rvHewan.adapter = listHewanAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_about -> {
                val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutIntent)
            }
        }
    }
}