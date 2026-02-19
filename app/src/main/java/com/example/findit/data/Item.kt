package com.example.findit.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val date: String,
    val type: String, // "LOST" or "FOUND"
    val contactInfo: String,
    val userName: String,
    val location: String
)
