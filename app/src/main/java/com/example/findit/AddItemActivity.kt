package com.example.findit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.findit.data.Item
import com.example.findit.data.ItemDatabase
import com.example.findit.databinding.ActivityAddItemBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AddItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar
        binding.topAppBar.setNavigationOnClickListener {
            finish()
        }

        binding.btnSave.setOnClickListener {
            saveItem()
        }
    }

    private fun saveItem() {
        val title = binding.etTitle.text.toString()
        val userName = binding.etUserName.text.toString()
        val location = binding.etLocation.text.toString()
        val description = binding.etDescription.text.toString()
        val type = if (binding.rbLost.isChecked) "LOST" else "FOUND"
        val contact = binding.etContact.text.toString()
        val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

        if (title.isNotEmpty() && description.isNotEmpty()) {
            val item = Item(
                title = title,
                description = description,
                date = date,
                type = type,
                contactInfo = contact,
                userName = userName,
                location = location
            )

            CoroutineScope(Dispatchers.IO).launch {
                ItemDatabase.getDatabase(this@AddItemActivity).itemDao().insertItem(item)
                finish()
            }
        }
    }
}
