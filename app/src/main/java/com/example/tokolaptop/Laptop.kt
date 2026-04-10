package com.example.tokolaptop

import java.io.Serializable

data class Laptop(
    val name: String,
    val specs: String,
    val price: String,
    val description: String,
    val imageResId: Int
) : Serializable