package com.example.findit

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.findit.data.ItemDatabase
import com.example.findit.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this, AddItemActivity::class.java))
        }

        observeItems()
    }

    private fun setupRecyclerView() {
        adapter = ItemAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun observeItems() {
        lifecycleScope.launch {
            ItemDatabase.getDatabase(this@MainActivity).itemDao().getAllItems().collect { items ->
                adapter.submitList(items)
            }
        }
    }
}
