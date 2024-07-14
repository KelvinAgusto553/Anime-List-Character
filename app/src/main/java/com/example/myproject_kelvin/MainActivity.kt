package com.example.myproject_kelvin

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject_kelvin.data.Karakter
import com.example.myproject_kelvin.data.ListKarakterAdapter
import com.example.myproject_kelvin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvKarakter: RecyclerView
    private val list = ArrayList<Karakter>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvKarakter = binding.rvKarakter
        binding.rvKarakter.setHasFixedSize(true)
        list.addAll(getListKarakter())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListKarakter(): ArrayList<Karakter> {
        val dataName = resources.getStringArray(R.array.data_nama)
        val dataDescription = resources.getStringArray(R.array.data_deskripsi)
        val dataPhoto = resources.getStringArray(R.array.data_photo)

        val listKarakter = ArrayList<Karakter>()
        for (i in dataName.indices) {
            val karakter = Karakter(
                dataName[i],
                dataDescription[i],
                dataPhoto[i]
            )
            listKarakter.add(karakter)
        }
        return listKarakter
    }

    private fun showRecyclerList() {
        rvKarakter.layoutManager = LinearLayoutManager(this)
        val listKarakterAdapter = ListKarakterAdapter(list)
        rvKarakter.adapter = listKarakterAdapter

        listKarakterAdapter.setOnItemClickCallback(object : ListKarakterAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Karakter) {
                showSelectedKarakter(data)
            }
        })
    }

    private fun showSelectedKarakter(karakter: Karakter) {
        Toast.makeText(this, "Kamu memilih " + karakter.name, Toast.LENGTH_SHORT).show()
    }
}